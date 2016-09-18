# first project
# helloword
# mvn clean package
# cmd :java -jar $\helloword.*.jar
# 配置mainefest
```
<plugin>
 			<groupId>org.apache.maven.plugins</groupId>
 			<artifactId>maven-shade-plugin</artifactId>
 			<version>2.4.3</version>
 			<executions>
 				<execution>
 					<phase>package</phase>		
 					<goals>
 						<goal>shade</goal>
 					</goals>
 					<configuration>
 						<transformers>
 							<transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer"> 
 								<mainClass>com.xiaoq.mvnBook.helloword.App</mainClass>
 							<!-- 	<manifestEntries>
			                    <Main-Class>${app.main.class}</Main-Class>
			                    <X-Compile-Source-JDK>${maven.compile.source}</X-Compile-Source-JDK>
			                    <X-Compile-Target-JDK>${maven.compile.target}</X-Compile-Target-JDK>
			                  </manifestEntries> -->
 							</transformer>
 						</transformers>
 					
 					</configuration>
 				</execution>
 			</executions>
 		</plugin>
```
