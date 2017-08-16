# requests-java
---

## 初衷
* java自带的HTTP库功能冗余,简化并仿python的requests库

---

## 使用方法

```java
    String url = "http://huangty.com";
    Requests requests = new Requests();
    String response = requests.get(url).text;
    // String response = requests.post(url).text;
    System.out.println(response);


传输参数
---
```java
    String url = "http://huangty.com";
    Requests requests = new Requests();
    requests.data = "data";
    String response = requests.get(url).text;
    // String response = requests.post("http://huangty.com").text;
    System.out.println(response);


```java
    String url = "http://huangty.com";
    Requests requests = new Requests();
    requests.data = "data";
    String response = requests.get(url).text;
    // String response = requests.post("http://huangty.com").text;
    System.out.println(response);
```