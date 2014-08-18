google-spreadsheets-access-java-celldemo
========================================

```sh
mvn archetype:generate -DgroupId=com.streambox.celldemo -DartifactId=celldemo -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
# update pom to look like the one in this dir
mvn clean package; java -cp target/uber-celldemo-1.0-SNAPSHOT.jar com.streambox.celldemo.CellDemo --username username@gmail.com --password secret
```
