# Diplomaterv
#### Oktatást segítő alkalmazás kibővítése felhasználók közötti csevegéssel és részletes kereséssel

**Feladat:**

Spring boot alkalmazás modulok, ami chat funkciót látnak el, egy adott szobába csatlakozhatnak be a userek és cseveghetnek. Részletes keresést valósít meg chat history-ban Elasticsearch segítségével. Az üzenetek küldéséhez és fogadásához Apache Kafka-t használok.

**Backend:**
  - Spring boot 2.3.3.RELEASE
  - Java 11
  - Maven
  - Apache Kafka 2.5.1
  - Elasticsearch 7.9.2

**Készítette:** Vécsi Ádám - Mérnökinformatikus MSc

**Témavezető:** Dr. Krizsán Zoltán - Egyetemi docens

### Docker containerek indítása (Elasticsearch, Kibana, Kafka, Zookeeper)

```sh
$ docker-compose up -d
```

| Alkalmazás | Elérés |
| ---------- | ------ |
| Elasticsearch | localhost:9200 |
| Kibana | localhost:5601 |
| ZooKeeper| localhost:2181 |
| Kafka Broker| localhost:9091 |
| Chat application| localhost:8082|