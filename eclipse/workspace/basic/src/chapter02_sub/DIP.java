package chapter02_sub;

class Controller{
	// 다른 클래스에 의존한다(의존성)
//	Service service = new Service();
	
	// 외부 주입
//	Service service;
	IService service;
	
	public Controller(IService service) {
		this.service = service;
	}
	
	void controllerMethod() {
		System.out.println("controller A");
		// 단계적인 호출
		service.serviceMethod();
	}
	
	void controllerMethod2() {
		System.out.println("controller B");
		service.serviceMethod2();
	}
}

interface IService{
	void serviceMethod();
	void serviceMethod2();
}

class Service implements IService{
	
	// 의존성 - 외/내부 주입
	// 내부 주입
//	Repository repository = new Repository();
	
	// 외부 주입
//	Repository repository;
	
	IRepository repository;
	
	Service(IRepository repository){
		this.repository = repository;
	}
	
	public void serviceMethod() {
		System.out.println("service A");
		repository.repositoryMethod();
	}
	
	public void serviceMethod2() {
		System.out.println("service A2");
		repository.repositoryMethod2();
	}
}

interface IRepository{
	void repositoryMethod();
	void repositoryMethod2();
}


class Repository implements IRepository{
	
	public void repositoryMethod() {
		System.out.println("repository A");
	}
	
	public void repositoryMethod2() {
		System.out.println("repository A2");
	}
}


class Repository2 implements IRepository{
	
	public void repositoryMethod() {
		System.out.println("repository B");
	}

	public void repositoryMethod2() {
		System.out.println("repository A2");
	}
}


public class DIP {
	public static void main(String[] args) {
		
		// 상용화
		// 테스트가 완료되어 상용화 된것은 변경하는 것이 좋지 않다(개방폐쇄법칙)
		Repository repository = new Repository();
		Repository2 repository2 = new Repository2();
		// 업캐스팅(묵시적)
		IRepository iRepository = repository;
		IService service = new Service(repository);
		Controller controller = new Controller(service);
		
		controller.controllerMethod();
		
		
	}
}
