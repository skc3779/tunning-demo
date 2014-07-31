JMH 사용샘플
===

JMH(Java Microbenchmark Harness)는 JDK를 오픈소스로 제공하는 OpenJDK에서 만든 성능측정용 라이브러리입니다.

해당소스는 [OpenJDK툴 사이트](http://openjdk.java.net/projects/code-tools/jmh)에서 다운로드 받을 수 있습니다.

해당 샘플은 gitHub에 있는 melix의 gradle plugin을 이용해 JMH를 테스트 할 수 있도록 작성된 샘플이며, Intellij IDE에서 Gradle를 이용한 사용방법을 다루고자 합니다.

본 내용은 저자 이상민이 지은 [자바성능튜닝 이야기](http://www.insightbook.co.kr/post/6685)를 바탕으로 작성한 샘플임을 알려드립니다.

### 소개목차

* JMH 샘플
* jmh-gradle-plugin 소개

---

### JMH 샘플

### jmh-gradle-plugin 소개
[플러그인] : https://github.com/melix/jmh-gradle-plugin

1.buildstript 설정

```
buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        maven { url 'http://repo.springsource.org/plugins-release' }
        jcenter()
    }
    dependencies {
        classpath 'org.springframework.build.gradle:propdeps-plugin:0.0.7'
        classpath 'me.champeau.gradle:jmh-gradle-plugin:0.1.2'
    }
}
```

2.dependencies 설정

```
    dependencies {

        jmh 'commons-io:commons-io:2.4'
        jmh 'org.openjdk.jmh:jmh-core:0.9.5'
        jmh 'org.openjdk.jmh:jmh-generator-annprocess:0.9,5'
        testCompile 'org.openjdk.jmh:jmh-core-benchmarks:0.9.5'
        testCompile 'org.openjdk.jmh:jmh-samples:0.9.5'

    }
```

3.jmh Task 설정

jmh 설정을 task의 변수로 사용 할 수 있도록 되어 있다.
참고로, 소스코드상에서 jmh option를 설정하기 위해 annotation 설정을 하여도 아래의 설정이 우선시 된다.

```
jmh {

    include = 'org.kangchun.jmh.SetContains.*'

    humanOutputFile = null
    resultsFile = project.file("${project.buildDir}/reports/jmh/results.txt") // results file
    resultFormat = 'CSV' // Result format type (one of CSV, JSON, NONE, SCSV, TEXT)
    benchmarkMode = 'avgt' // Benchmark mode. Available modes are: [Throughput/thrpt, AverageTime/avgt, SampleTime/sample, SingleShotTime/ss, All/all]
    iterations = 1 // Number of measurement iterations to do.
    timeOnIteration = '1s' // Time to spend at each measurement iteration.
    batchSize = 1 // Batch size: number of benchmark method calls per operation. (some benchmark modes can ignore this setting)
    fork = 1 // How many times to forks a single benchmark. Use 0 to disable forking altogether
    timeUnit = 'ms' // Output time unit. Available time units are: [m, s, ms, us, ns].
    warmupIterations = 1 // Number of warmup iterations to do.
    warmup = '1s' // Time to spend at each warmup iteration
    warmupBatchSize = 1 // Warmup batch size: number of benchmark method calls per operation.
    warmupForks = 1 // How many warmup forks to make for a single benchmark. 0 to disable warmup forks.

/*
    humanOutputFile = project.file("${project.buildDir}/reports/jmh/human.txt") // human-readable output file
    resultsFile = project.file("${project.buildDir}/reports/jmh/results.txt") // results file
    resultFormat = 'CSV' // Result format type (one of CSV, JSON, NONE, SCSV, TEXT)
    threads = 1 // Number of worker threads to run with.
    threadGroups = [2,3,4] //Override thread group distribution for asymmetric benchmarks.
    verbosity = 'NORMAL' // Verbosity mode. Available modes are: [SILENT, NORMAL, EXTRA]
    operationsPerInvocation = 1 // Operations per invocation.
*/
}


```

4.gradle 사용법

```
#> gradle clean jmh
```
