# Unofficial SkriptHub Java API (SHJA)
This is a Java ported library of the SkriptHub API

This project is under heavy development.

Pull requests welcome.

## Adding SHJA as a dependency
SHJA currently uses Jitpack https://jitpack.io/#TheLimeGlass/SkriptHub-Java-API/Alpha
### Maven
In your `pom.xml` add:
```xml
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
    <groupId>com.github.TheLimeGlass</groupId>
    <artifactId>SkriptHub-Java-API</artifactId>
    <version>Alpha</version>
</dependency>

```
### Gradle
In your `build.gradle` add: 
```groovy
repositories {
  jcenter()
  maven {
    url 'https://jitpack.io'
  }
}

dependencies {
  compile 'com.github.TheLimeGlass:SkriptHub-Java-API:Alpha'
}
```
Check the link above for SBT and leiningen support.

Examples: https://github.com/TheLimeGlass/SkriptHub-Java-API/tree/master/src/test/java/me/limeglass/skripthub
