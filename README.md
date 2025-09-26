# KidsPOS4j

[![Release](https://jitpack.io/v/KidsPOSProject/KidsPOS4j.svg)](https://jitpack.io/#KidsPOSProject/KidsPOS4j)

子供向けPOSシステムのJava実装ライブラリ

## 🚨 Deprecation Notice

**このリポジトリは現在メンテナンスされていません。**
新規プロジェクトでの使用は推奨されません。

## 🛠️ 技術スタック

- **Java**: 1.7+
- **ビルドツール**: Gradle
- **データベース**: SQLite (sqlite-jdbc)
- **HTTPクライアント**:
  - OkHttp3
  - Retrofit2
- **JSONパーサー**: Jackson
- **リアクティブプログラミング**: RxJava
- **テストフレームワーク**: JUnit 4.12
- **コードカバレッジ**: JaCoCo

## 📦 インストール

### Gradle

`settings.gradle` または `build.gradle` (プロジェクトレベル)
```gradle
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

`build.gradle` (アプリレベル)
```gradle
dependencies {
    implementation 'com.github.KidsPOSProject:KidsPOS4j:Tag'
}
```

### Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.KidsPOSProject</groupId>
    <artifactId>KidsPOS4j</artifactId>
    <version>Tag</version>
</dependency>
```

## 📄 ライセンス

このプロジェクトのライセンスについては、[LICENSE](LICENSE)ファイルをご参照ください。

## 🤝 コントリビューション

このプロジェクトは現在メンテナンスされていないため、新規のプルリクエストは受け付けていません。
