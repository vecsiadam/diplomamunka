# Diplomaterv
## Oktatást segítő alkalmazás kibővítése felhasználók közötti csevegéssel és részletes kereséssel

### Feladat:

Spring boot alkalmazás, ami chat funkciót lát el, egy adott szobába csatlakozhatnak be a felhasználók és cseveghetnek. Részletes keresést valósít meg chat előzményben Elasticsearch segítségével. Az üzenetek küldéséhez és fogadásához Apache Kafka-t használok, valamint websocketen mennek az üzenetek.

### Backend:
  - Spring boot 2.3.3.RELEASE
  - Java 11
  - Maven
  - Apache Kafka 2.5.1
  - Elasticsearch 7.9.2

### Leírás: 

Ez egy Spring Boot alklamazás, ami felhasználók közötti csevegést valósít meg. Tartalmaz egy Kafka Producer-t és egy Kafka Consumer-t, ami az üzenetek küldésé ért és fogadásáért felelős, az üzenetek websocketen mennek. Ahhoz, hogy az alkalmazás elinduljon először is kell hogy fusson, a Zookeeper, Kafka és az Elasticsearch, ezek elengedhetetlenek, erre készítettem egy docker compose fájlt, ami elindítja a szükséges alkalmazásokat. Ha ezek megvanank, az alkalmazás induláskor létrehoz és csatlakozik egy Kafka topic-hoz, csatlakozik és létrehoz indexet az Elasticsearc-höz, létrehoz és feltölt default adatokkal egy H2 embedded adatbázist. Létrehoz egy socket kapcsolatot, és csatlakozik hozzá. User-eket, Room-okat lehet létrehozni, lekérdezni, módosítani. Ezek a felhasználók tudnak becsatlakozni szobákba, amiket tantárgyakhoz rendelek. Ha a http://localhost:8082 url-t beírjuk, egy minimális UI felületet is készítettem jquery segítségével, nem kifejezetten erről szól ez a projekt, inkább a backend oldalról, de itt ki lehet választani szobát, egy neptun kód megadással már működik is a csevegés. Amikor elküldünk egy üzenetet, először letároljuk egy Elasticsearch index-ben, majd egy H2 adatbázis táblában és csak ezek után érkezik meg a másik oldalra. A csevegési előzményekben való kereséshez az Elasticsearchet használom, de úgy gondoltam, ha bármi történik az index-ekkel, akkor az SQL adatbázisból vissza állítható az adat.

### Docker

Két docker compose fájlt hoztam létre:
  - docker-compose.yml - Elasticsearch, Kibana, Kafka Broker, Zookeeper
  - docker-compose_chat.yml - Elasticsearch, Kibana, Kafka Broker, Zookeeper, Chat

#### docker-compose.yml (Elasticsearch, Kibana, Kafka, Zookeeper)

1. Docker compose-zal indítjuk az alkalmazásokat.
```sh
$ docker-compose up -d
```
2. Docker container leállítása és törlése.
```sh
$  docker-compose -f docker-compose_chat.yml down 
```

| Alkalmazás | Elérés |
| ---------- | ------ |
| Elasticsearch | localhost:9200 |
| Kibana | localhost:5601 |
| ZooKeeper| localhost:2181 |
| Kafka Broker| localhost:9091 |

Lokálisan szükséges indítani a Chat alkalmazást, IDE segítségével. 

#### docker-compose_chat.yml (Elasticsearch, Kibana, Kafka, Zookeeper, Chat)

1. Feltöltöttem a legfrissebb .war fájlt, amit build-eltem, hogy megkönnytsem az indítást.

2. Docker image-t készítünk a Chat alkalmazásból.
```sh
$ docker-compose -f docker-compose_chat.yml build
```
3. Docker compose-zal indítjuk az összes alkalmazást, beleértve a Chat-et is.
```sh
$ docker-compose -f docker-compose_chat.yml up -d
```
4. Docker container leállítása és törlése.
```sh
$  docker-compose -f docker-compose_chat.yml down 
```

| Alkalmazás | Elérés |
| ---------- | ------ |
| Elasticsearch | localhost:9200 |
| Kibana | localhost:5601 |
| ZooKeeper| localhost:2181 |
| Kafka Broker| localhost:9091 |
| Chat Application| localhost:8082 |

### Alkalmazás swagger elérése
```sh
http://localhost:8082/swagger-ui.html
```
### Alkalmazás UI elérése
```sh
http://localhost:8082
```


**Készítette:** Vécsi Ádám - Mérnökinformatikus MSc

**Témavezető:** Dr. Krizsán Zoltán - Egyetemi docens