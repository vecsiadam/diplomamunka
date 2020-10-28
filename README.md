# Diplomaterv
## Oktatást segítő alkalmazás kibővítése felhasználók közötti csevegéssel és részletes kereséssel

### Feladat:

Spring boot alkalmazás modulok, ami chat funkciót látnak el, egy adott szobába csatlakozhatnak be a userek és cseveghetnek. Részletes keresést valósít meg chat history-ban Elasticsearch segítségével. Az üzenetek küldéséhez és fogadásához Apache Kafka-t használok.

### Backend:
  - Spring boot 2.3.3.RELEASE
  - Java 11
  - Maven
  - Apache Kafka 2.5.1
  - Elasticsearch 7.9.2

### Leírás: 

Ez egy múlti modulos Spring Boot alklamazás, ami felhasználók közötti csevegést valósít meg. A Chat Application modul, ami felelős az indulásért. Tartalmaz egy Kafka Producer és egy Kafka Consumer modult, ami az üzenetek küldésé ért és fogadásáért felelős, valamint egy API modult, ami azokat a modelleket és interface-ket tartalmazza, amik több modulban is használva vannak. Ahhoz, hogy az alkalmazás elinduljon először is kell hogy fusson, a Zookeeper, Kafka és az Elasticsearch, ezek elengedhetetlenek, erre készítettem egy docker compose fájlt, ami elindítja a szükséges alkalmazásokat. Ha ezek megvanank, az alkalmazás induláskor létrehoz és csatlakozik egy Kafka topic-hoz, csatlakozik és létrehoz indexet az Elasticsearc-höz, létrehoz és feltölt default adatokkal egy H2 embedded adatbázist. Létrehoz egy socket kapcsolatot, és csatlakozik hozzá. User-eket, Room-okat lehet létrehozni, lekérdezni, módosítani. Ezek a felhasználók tudnak becsatlakozni szobákba, amiket tantárgyakhoz rendelek. Ha a http://localhost:8082 url-t beírjuk, egy minimális UI felületet is készítettem jquery segítségével, nem kifejezetten erről szól ez a projekt, inkább a backend oldalról, de itt ki lehet választani szobát, egy neptun kód megadással már működik is a csevegés. Amikor elküldünk egy üzenetet, először letároljuk egy Elasticsearch index-ben, majd egy H2 adatbázis táblában és csak ezek után érkezik meg a másik oldalra. A csevegési előzményekben való kereséshez az Elasticsearchet használom, de úgy gondoltam, ha bármi történik az index-ekkel, akkor az SQL adatbázisból vissza állítható az adat.

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


### Alkalmazás swagger
```sh
http://localhost:8082/swagger-ui.html
```


**Készítette:** Vécsi Ádám - Mérnökinformatikus MSc

**Témavezető:** Dr. Krizsán Zoltán - Egyetemi docens