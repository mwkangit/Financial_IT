
import pandas as pd
import ssl
import requests
from bs4 import BeautifulSoup
import openpyxl

class StockItem():
    def __init__(self):

        # 코스피 스크래핑 엑셀 저장
        self.save_item_kospi()

        # 코스닥 스크래핑 엑셀 저장
        self.save_item_kosdaq()

        # 코스피 종목 가져오기
        kospi_df = self.get_item_kospi()

        # 코스닥 종목 가져오기
        kosdaq_df = self.get_item_kosdaq()

        print('코스피 종목 수:  ', len(kospi_df))
        print(kospi_df[['회사명', '종목코드']])
        print('코스닥 종목 수:  ', len(kosdaq_df))
        print(kosdaq_df[['회사명', '종목코드']])

    # 코스피 종목 리스트를 가져오는 메서드(해당 메소드를 작성해주시면 됩니다.)

    def save_item_kospi(self):
      url = "http://kind.krx.co.kr/corpgeneral/corpList.do?method=download&searchType=13&marketType=stockMkt"
      res = requests.get(url)
      soup = BeautifulSoup(res.text, 'html.parser')
      datas = soup.find_all('tr')
      index = 0

      trData = soup.find_all('tr')

      tdData = trData[0].find_all('th')
      
      # Column 생성
      header = []	 
      headerLen = len(tdData)
      for i in range(0, headerLen):
        header.append(tdData[i].text)

      # Data 정제 및 입력
      rowList = []
      columnList = []
      trDataLen = len(trData)
      for i in range(1,trDataLen):
        tdData = trData[i].find_all('td')
        tdDataLen = len(tdData)
        for j in range(0,tdDataLen):
          element = tdData[j].text.strip()
          #if j == 1:
          #  element = element.lstrip("0")
          columnList.append(element)

        rowList.append(columnList)
        columnList = []
      
      # DataFrame 생성
      result = pd.DataFrame(rowList, columns=header)

      # Data 저장
      result.to_excel('kospi_test.xlsx', index=False)

    def save_item_kosdaq(self):
      url = "http://kind.krx.co.kr/corpgeneral/corpList.do?method=download&searchType=13&marketType=kosdaqMkt"
      res = requests.get(url)
      soup = BeautifulSoup(res.text, 'html.parser')
      datas = soup.find_all('tr')
      index = 0

      trData = soup.find_all('tr')

      tdData = trData[0].find_all('th')
      
      # Column 생성
      header = []
      headerLen = len(tdData)
      for i in range(0, headerLen):
        header.append(tdData[i].text)

      # Data 정제 및 입력
      rowList = []
      columnList = []
      trDataLen = len(trData)
      for i in range(1,trDataLen):
        tdData = trData[i].find_all('td')
        tdDataLen = len(tdData)
        for j in range(0,tdDataLen):
          element = tdData[j].text.strip()
          #if j == 1:
          #  element = element.lstrip("0")
          columnList.append(element)

        rowList.append(columnList)
        columnList = []

      # DataFrame 생성
      result = pd.DataFrame(rowList, columns=header)

      # Data 저장
      result.to_excel('kosdaq_test.xlsx', index=False)

    def get_item_kospi(self):
      # Data 읽기
      df = pd.read_excel('./kospi_test.xlsx')
      return df
      
    # 코스닥 종목 리스트를 가져오는 메서드(해당 메소드를 작성해주시면 됩니다.)
    def get_item_kosdaq(self):
      # Data 읽기
      df = pd.read_excel('./kosdaq_test.xlsx')
      return df

if __name__ == "__main__":

    ssl._create_default_https_context = ssl._create_unverified_context
    
    s = StockItem()
