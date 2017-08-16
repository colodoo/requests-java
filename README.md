# requests-java

## 初衷
* Java自带的HTTP库功能冗余,简化并仿Python的requests库

## 使用方法

### 普通请求
```java
    String url = "http://huangty.com";
    Requests requests = new Requests();
    String response = requests.get(url).text;
    // String response = requests.post(url).text;
    System.out.println(response);

```

### 传输参数
```java
    String url = "http://huangty.com";
    Requests requests = new Requests();
    requests.data = "data";
    String response = requests.get(url).text;
    // String response = requests.post(url).text;
    System.out.println(response);

```

### 添加头部
```java
    String url = "http://huangty.com";
    Requests requests = new Requests();
    requests.addHeader("Content-Type", "application/json;charset=utf-8");
    String response = requests.get(url).text;
    // String response = requests.post(url).text;
    System.out.println(response);
```