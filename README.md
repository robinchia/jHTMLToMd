jHTMLToMd
=========

java版的HTML转换为Markdown文件工具
author robin chia
-------
***基于[https://github.com/pnikosis/jHTML2Md](https://github.com/pnikosis/jHTML2Md)项目修改而来***

使用方法：

一、转换url页面为.md文件
```java
String url = "your url";
URL url = new URL(url);
String parsedText = HtmlToMd.convert(url, 60000);
String mdPath = "/home/robin/Desktop/"; // your md file path
FilesUtil.newFile("mdName", mdPath + parsedText, "utf-8");
```

二、转换本地的html文件为.md文件

    String pathFile = "test.html";
    File f = new File(pathFile);
    String parsedText = HtmlToMd.convertFile(f, "gbk");
    String mdPath = "/home/robin/Desktop/"; // your md file path
    FilesUtil.newFile("mdName", mdPath + parsedText, "utf-8");

三、可以根据相应的api来转换（深度探索...:)）

    HtmlToMd.convertHtml(String html, String charset);
    HtmlToMd.htmlToJekyllMd(String htmlPath, String mdPath, String charset);
    HtmlToMd.htmlToHexoMd(String htmlPath, String mdPath, String charset);
    ......

-------   
注： 本工具使用了[jSoup](http://jsoup.org/)作为解析HTML的jar库文件