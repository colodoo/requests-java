# requests-java

## 初衷
* Java自带的HTTP库功能冗余,简化并仿Python的requests库

## 使用方法

### 两种传输URL方式
```java
    // 第一种
    String url = "http://huangty.com";
    Requests requests = new Requests(url);
    String response = requests.get().text;
    // 第二次
    String url = "http://huangty.com";
    Requests requests = new Requests();
    String response = requests.get(url).text;

```

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
    List<Map<String, String>> headers = new ArrayList<Map<String, String>>();
        HashMap<String, String> header = new HashMap<String, String>(){
        {
            put("Content-Type", "application/json;charset=utf-8");
            // ...
        }
    };
    headers.add(header);
    requestss.headers = headers;
    String response = requests.get(url).text;
    // String response = requests.post(url).text;
    System.out.println(response);
```