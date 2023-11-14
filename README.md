Add Dependency and configure create instance

```xml
<dependency>
    <groupId>io.github.hcelebi</groupId>
    <artifactId>jira-agile-java-client</artifactId>
    <version>1</version>
</dependency>
```

```java
JiraAgileRestClient client = new JiraAgileRestClient("baseUri", "token", "workspace", HttpClient.newHttpClient());
```
