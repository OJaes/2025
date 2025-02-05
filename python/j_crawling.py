# HTML 선택자 학습 이후 

# Python 크롤링이란?
# Python 크롤링(Web Crawling)이란 웹사이트에서 데이터를 자동으로 수집하는 기술
# 웹페이지의 HTML 구조를 분석하여 원하는 정보를 추출하는 것이 핵심


# 크롤링의 종류

# 1. 정적 웹 크롤링
# - 웹사이트가 JavaScript 없이 정적인 HTML을 반환하는 경우
# - requests + BeautifulSoup 사용
# - 속도가 빠르고 간단함

##################################################

# import requests
# from bs4 import BeautifulSoup

# url = "https://example.com"
# response = requests.get(url)

# soup = BeautifulSoup(response.text, "html.parser")
# title = soup.find("h1").text

# print("페이지 제목:", title)


##################################################

# 2. 동적 웹 크롤링
# - 웹사이트가 JavaScript로 데이터를 동적으로 로드하는 경우
# - Selenium을 사용하여 실제 브라우저를 실행하고 데이터를 수집
# - 로그인, 버튼 클릭, 무한 스크롤 등 인터랙션이 필요할 때 사용

##################################################

# from selenium import webdriver
# from selenium.webdriver.common.by import By
# import time

# driver = webdriver.Chrome()
# driver.get("https://example.com")

# time.sleep(3)

# title = driver.find_element(By.TAG_NAME, "h1").text
# print("페이지 제목:", title)

# driver.quit()

##################################################



##################################################

# Selenium 을 사용하여 특정 요소 찾기 및 데이터 추출

##################################################

# from selenium.webdriver.common.by import By

# element = driver.find_element(By.CSS_SELECTOR, "h1")
# print(element.text)

# element = driver.find_element(By.XPATH, "//h1")
# print(element.text)

##################################################



##################################################

# Selenium으로 입력 및 버튼 클릭

##################################################

# driver.get("https://www.naver.com")

# search_box = driver.find_element(By.NAME, "query")
# search_box.send_keys("Python Selenium 크롤링")

# search_box.send_keys(Keys.RETURN)

# time.sleep(3)

# titles = driver.find_elements(By.CSS_SELECTOR, ".title")
# for title in titles:
#     print(title.text)

# driver.quit()

##################################################



##################################################

# Selenium으로 스크롤 내리기

##################################################

# driver.get("https://example.com")

# driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")

# time.sleep(3)

##################################################

# or

##################################################

# import time

# last_height = driver.execute_script("return document.body.scrollHeight")

# while True:
#     driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
#     time.sleep(2)
#     new_height = driver.execute_script("return document.body.scrollHeight")
    
#     if new_height == last_height: 
#         break
#     last_height = new_height

##################################################



##################################################

# Selenium으로 동적 데이터 크롤링 (클릭)

##################################################

# more_button = driver.find_element(By.XPATH, "//button[text()='더보기']")
# more_button.click()

# time.sleep(3)

##################################################



##################################################