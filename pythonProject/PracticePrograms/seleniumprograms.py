
from selenium import webdriver

from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
from webdriver_manager.microsoft import EdgeChromiumDriverManager
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.edge.service import Service
#from selenium.webdriver.firefox.service import Service
driver=webdriver.Chrome(service=Service(ChromeDriverManager().install()))
# driver=webdriver.Edge(service=Service(EdgeChromiumDriverManager().install()))
# driver=webdriver.Firefox(service=Service(GeckoDriverManager().install() ))
driver.implicitly_wait(20)
driver.get("https://www.flipkart.com")
driver.maximize_window()
#print(driver.title)
driver.find_element(by=By.XPATH,value="//button[text()='✕']").click()

driver.find_element(by=By.XPATH,value="//input[@name='q']").send_keys("iphone")
driver.find_element(by=By.XPATH,value="//button[@type='submit']").click()
listofPhones=driver.find_elements(by=By.XPATH,value="//div[contains(text(),'APPLE iPhone')]")
listofPricesOfpHone=driver.find_elements(by=By.XPATH,value="//div[@class='MIXNux']//parent::a//descendant::div[@class='_25b18c']//div[1]")
listofPhoneNames=[]
listofPrices=[]
for x in listofPhones:
    listofPhoneNames.append(x.text)
for y in listofPricesOfpHone:
    listofPrices.append(y.text)
print(driver.title)
print(listofPhoneNames)
print(listofPrices)
#driver.quit()

