# Financial_IT

## Description

본 프로젝트는 Kospi, Kosdaq 정보를 각 로직을 사용하여 생성된 결과를  API로 클라이언트에게 전송한다. Kospi, Kosdaq 데이터는 크롤링을 통해 MariaDB에 저장하였으며 JPA를 통해 데이터에 로직을 적용한다.



------



## Environment

[![framework](https://camo.githubusercontent.com/a6677a4ec12bd03f835c62db09a8db96a6d726afe3985c8fbf5c43db9b6cb8ad/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4672616d65776f726b2d537072696e67426f6f742d677265656e)](https://camo.githubusercontent.com/a6677a4ec12bd03f835c62db09a8db96a6d726afe3985c8fbf5c43db9b6cb8ad/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4672616d65776f726b2d537072696e67426f6f742d677265656e)[![framework](https://camo.githubusercontent.com/2b75d756cdb751bd9b97416a876723b059d3593b90946c8aaca2fbe13d03730e/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4c616e67756167652d6a6176612d623037323139)](https://camo.githubusercontent.com/2b75d756cdb751bd9b97416a876723b059d3593b90946c8aaca2fbe13d03730e/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4c616e67756167652d6a6176612d623037323139)![flat](https://img.shields.io/badge/DBMS-MariaDB-yellow?style=flat)

Framework: `Spring Boot` 2.6.4

Project: `Gradle`

Packaging: `Jar`

IDE: `Intellij`

ORM: `JPA`(Hibernate, Spring Data JPA)

DBMS: `MariaDB`

Dependencies: `Spring Web`, `Spring Data JPA`, `Lombok`



------



## Installation

[![Linux](https://camo.githubusercontent.com/878e15b4f7576e844856dc60d855ba0587d3d2bc56211fbe69734ebccb13b068/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4c696e75782d4643433632343f7374796c653d666f722d7468652d6261646765266c6f676f3d6c696e7578266c6f676f436f6c6f723d626c61636b)](https://camo.githubusercontent.com/878e15b4f7576e844856dc60d855ba0587d3d2bc56211fbe69734ebccb13b068/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4c696e75782d4643433632343f7374796c653d666f722d7468652d6261646765266c6f676f3d6c696e7578266c6f676f436f6c6f723d626c61636b)

```shell
./gradlew build
cd build/libs
java -jar hello-spring-0.0.1-SNAPSHOT.jar
```

[![Windows](https://camo.githubusercontent.com/41281b9a32f13ac5b9d41ed9bae12c0de662f948f9bf59fd19df354fe49af146/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f57696e646f77732d3030373844363f7374796c653d666f722d7468652d6261646765266c6f676f3d77696e646f7773266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/41281b9a32f13ac5b9d41ed9bae12c0de662f948f9bf59fd19df354fe49af146/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f57696e646f77732d3030373844363f7374796c653d666f722d7468652d6261646765266c6f676f3d77696e646f7773266c6f676f436f6c6f723d7768697465)

```shell
gradlew build
cd build/libs
java -jar hello-spring-0.0.1-SNAPSHOT.jar
```



------



## Core Feature



### 1. 해당 종목의 테마 이름 

- **해당종목의 테마이름 조회**

| URL | localhost:8080/stock/theme?codeName={종목명} |
| --- | --- |
| Content-Type | None |
| Request Method | GET |

- **Query String**

| **파라미터명** | **타입** | **필수여부** | **설명** |
| --- | --- | --- | --- |
| codeName | String | Y | 조회하고자하는 종목명 |


- **Response body**

| **엘리먼트 명** | **타입** | **Depth** | **배열구분** | **설명** | **값 구분** |
| --- | --- | --- | --- | --- | --- |
| status | String | 1 | N | 응답 상태 코드 |
| Result | String | 1 | N | 응답 상태에 대한 결과값 | Success : 성공(정상)Fail : 실패(오류) |
| description | String | 1 | N | 응답 결과에 대한 설명 |
| theme | String | 1 | N | 요청된 종목코드 종목의 테마명 |


- **샘플 JSON예제**


| **실패할 경우 샘플** |
| --- |
|{&quot;status&quot;: &quot;400&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;BAD REQUEST&quot;}|
|{&quot;status&quot;: &quot;404&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;NOT FOUND&quot;}|



| **성공할 경우 샘플** |
| --- |
|{&quot;status&quot;: &quot;200&quot;, &quot;result&quot;: &quot;sucess&quot;, &quot;description&quot;: &quot;OK&quot;, &quot;theme&quot;: &quot;반도체_생산&quot;} |




### 2. 코스피/코스닥 상위 5종목 시총 합

| URL | localhost:8080/stock/marketcap/sum?market={시장종류} |
| --- | --- |
| Content-Type | None |
| Request Method | GET |

- **Query String**

| **파라미터명** | **타입** | **필수여부** | **설명** |
| --- | --- | --- | --- |
| market | String | Y | 조회하고자하는 시장종류 |


- **Response body**

| **엘리먼트 명** | **타입** | **Depth** | **배열 구분** | **설명** | **값 구분** |
| --- | --- | --- | --- | --- | --- |
| status | String | 1 | N | 응답 상태 코드 |
| result | String | 1 | N | 응답 상태에 대한 결과값 | Success : 성공(정상)Fail : 실패(오류) |
| description | String | 1 | N | 응답 결과에 대한 설명 |
| sum | String | 1 | N | 요청된 시장의 상위 5종목의 시가총액 합 |


- **샘플 JSON예제**

| **실패할 경우 샘플** |
| --- |
|{&quot;status&quot;: &quot;400&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;BAD REQUEST&quot;}|
|{&quot;status&quot;: &quot;404&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;NOT FOUND&quot;}|



| **성공할 경우 샘플** |
| --- |
| {&quot;status&quot;: &quot;200&quot;, &quot;result&quot;: &quot;sucess&quot;, &quot;description&quot;: &quot;OK&quot;, &quot;sum&quot;:&quot;3929161&quot;} |




### 3. 코스피/코스닥 상위 30개 종목 코드 및 종목명

| URL | localhost:8080/stock/code/30?market={시장종류} |
| --- | --- |
| Content-Type | None |
| Request Method | GET |

**- Query String**

| **파라미터명** | **타입** | **필수여부** | **설명** |
| --- | --- | --- | --- |
| market | String | **Y** | 조회하고자하는 시장종류 |


- **Response body**

| **엘리먼트 명** | **타입** | **Depth** | **배열 구분** | **설명** | **값 구분** |
| --- | --- | --- | --- | --- | --- |
| status | String | 1 | N | 응답 상태 코드 |
| result | String | 1 | N | 응답 상태에 대한 결과값 | Success : 성공(정상)Fail : 실패(오류) |
| description | String | 1 | N | 응답 결과에 대한 설명 |
| data | Array | 1 | Y | 요청된 시장의 상위 30종목의 종목코드와 종목명 |
| code | String | 2 | N | 종목코드 |
| codeName | String | 2 | N | 종목명 |

- **샘플 JSON예제**

| **실패할 경우 샘플** |
| --- |
|{&quot;status&quot;: &quot;400&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;BAD REQUEST&quot;}|
|{&quot;status&quot;: &quot;404&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;NOT FOUND&quot;}|

| **성공할 경우 샘플** |
| --- |
|{"status":"200","result":"success","description":"OK","data":[{"code":"245620","code_name":"EDGC"},{"code":"083450","code_name":"GST"},{"code":"028150","code_name":"GS홈쇼핑"}, ... ,{"code":"023910","code_name":"대한약품"},{"code":"006620","code_name":"동구바이오제약"}]} |



### 4. 종목코드로 기업 종합 정보 조회

| URL | localhost:8080/stock/code/detail?code={종목코드} |
| --- | --- |
| Content-Type | None |
| Request Method | GET |

- **Query String**

| **파라미터명** | **타입** | **필수여부** | **설명** |
| --- | --- | --- | --- |
| code | String | **Y** | 조회하고자하는 종목코드 |


- **Response body**

| **엘리먼트명** | **타입** | **Depth** | **배열구분** | **설명** | **값 구분** |
| --- | --- | --- | --- | --- | --- |
| status | String | 1 | N | 응답 상태 코드 ||
| result | String | 1 | N | 응답 상태에 대한 결과값 | Success : 성공(정상)Fail : 실패(오류) |
| description | String | 1 | N | 응답 결과에 대한 설명 ||
| data | Object | 1 | N | 응답 결과 데이터 ||
| code | String | 2 | N | 종목코드 ||
| codeName | String | 2 | N | 종목명 ||
| thema_name | String | 2 | N | 테마 이름 ||
| sub_price | String | 2 | N | 대용가 ||
| roe | String | 2 | N | ROE ||
| per | String | 2 | N | per ||

- **샘플 JSON예제**


| **실패할 경우 샘플** |
| --- |
|{&quot;status&quot;: &quot;400&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;BAD REQUEST&quot;}|
|{&quot;status&quot;: &quot;404&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;NOT FOUND&quot;}|

| **성공할 경우 샘플** |
| --- |
|{"status":"200","result":"success","description":"OK","data":{"code":"091990","code_name":"셀트리온헬스케어","thema_name":null,"sub_price":134320.0,"roe":3.9,"per":378.41}} |
