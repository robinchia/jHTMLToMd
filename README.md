jHTMLToMd
=========

java版的HTML转换为Markdown文件工具  
author robin chia  
-------  
  
使用方法：  
  
一、转换url页面为.md文件  
  String aurl = "your url";  
  URL url = new URL(aurl);  
  String parsedtext1 = HtmlToMd.convert(url, 60000);  
  String mdpath = "/home/robin/Desktop/";//your md file path  
  FilesUtil.newFile("mdname", mdpath+parsedtext1, "utf-8");  
  
二、转换本地的html文件为.md文件  
   String pathfile = "/var/www/html/wiznote/推荐给开发人员的实用命令行工具.html";  
   File f = new File(pathfile);  
   String parsedtext2 = HtmlToMd.convertfile(f, "gbk");  
   String mdpath = "/home/robin/Desktop/";//your md file path  
   FilesUtil.newFile("mdname", mdpath+parsedtext2, "utf-8");  
三、可以根据相应的api来转换（深度探索...:)）  
    HtmlToMd.converthtml(String  html, String charset);  
    HtmlToMd.htmlToJeykyllmd(String htmlpath,String mdpath,String charset);  
    HtmlToMd.htmlToHexoMd(String htmlpath,String mdpath,String charset);  
     ......  

-------   
注： 本工具使用了[jSoup](http://jsoup.org/)作为解析HTML的jar库文件




