from selenium import webdriver
from time import sleep
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
COUNT = 100
URL = 'https://www.saramin.co.kr/zf_user/search?cat_kewd=87&exc_keyword=국비%2C교육&search_optional_item=y&search_done=y&panel_count=y&preview=y&recruitPage=1&recruitSort=relation&recruitPageCount={COUNT}&mainSearch=n'
driver.get(URL)

sleep(5)

main_items = []

recruits_items = driver.find_elements(By.CLASS_NAME,'item_recruit')

for item in recruits_items:
    job_tit = item.find_element(By.CLASS_NAME,'job_tit')
    a = job_tit.find_element(By.TAG_NAME,'a')
    title = a.get_attribute('title')
    url = a.get_attribute('href')

    corp_name = item.find_element(By.CLASS_NAME,'corp_name')
    company_name = corp_name.find_element(By.TAG_NAME, 'a')

    main_items.append({'title' : title, 'url' : url, 'company_name' : company_name})

    print(f'공고명 : {title} / 공고 페이지 : {url} / 공고 회사 : {company_name.text}')

for item in main_items:
    driver.get(item[url])