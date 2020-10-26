# Diplomaterv
#### Oktatást segítő alkalmazás kibővítése felhasználók közötti csevegéssel és részletes kereséssel

**Feladat:**

Ez Spring boot alkalmazás, ami chat funkciót lát el két fél között, valamint részletes keresést valósít meg elasticsearch-el. Keresést metadataban, chat history-ban gondoltam.

**Backend:**
  - Spring boot 2.3.3.RELEASE
  - Java 11
  - Maven
  - Apache Kafka 2.5.1.
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
| Kafka Producer| localhost:8080|
| Kafka Consumer| localhost:8081|