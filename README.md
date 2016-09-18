#环境搭配开始
<h5>主要用于学习maven的仓库</h5>
=================================================
<div>
<span>准备环境(environment:win7,jdk8,eclipse,maven3,nexus,git)</span>

<h6>maven3环境</h6>http://maven.apache.org/download.cgi
&nbsp;&nbsp;
M2_HOME=$\apache-maven-3.3.9<br/>

设置path:%M2_HOME%\bin<br/>
cmd check:mvn -version<br/>
<span>第一次我找到%M2_HOME%\conf\settings.xml设置&ltlocalRepository&gt$\m2_repositroy&ltlocalRepository&gt</span><br/>
cmd help:mvn help:system<br/>
拷贝 settings.xml 到.m2下面<br/>

<h6>nexus环境建立</h6>https://www.sonatype.com/download-oss-sonatype<br/>
&nbsp;&nbsp;
NEXUS_HOME=$\nexus-3.0.2-02<br/>
设置path:%NEXUS_HOME%\bin<br/>

编辑 bin\nexus.vmoptions <br/>
-Dkaraf.data=$\nexus_data<br/>
-Djava.io.tmpdir=$\nexus_temp<br/>
编辑etc\org.sonatype.nexus.cfg <br/>
application-port=9091<br/>
application-host=127.0.0.1<br/>

简单设置参见http://blog.csdn.net/fengyunhaitan/article/details/51685498<br/>
cmd nexus.exe /run<br/>

打开 http://localhost:9091/my_nexus/ 可以看到自己的nexus私人仓库
</div>

#环境搭配完成
