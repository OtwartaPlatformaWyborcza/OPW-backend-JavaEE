# Otwarta Platforma Wyborcza
Otwarta Platforma Wyborcza (OPW) to oprogramowanie klasy enterprise, którego podstawowym zadaniem jest niezależna i obiektywna weryfikacja wyników wyborów prezydenckich 2015. Celem projektu OPW **nie jest kompletna implementacja wymagań sprecyzowanych przez PKW** w ramach projektu PW2 (Platforma Wyborcza 2).   

# Członkowie
Sortowanie alfabetyczne po imieniu.  

| Członek  | Rola  |
| ------------- | ------------- |
| AdamK | Architektura, Java  |
| PawełP | Architektura, Java |
| PrzemekJ | Analiza |
| RafałR | Analiza i Organizacja |
| RobertP | Analiza |

**Jak do nas dołączyć?**  
Aby do nas dołączyć otwórz proszę nowy issue w repozytorium. Komunikacja odbywa się poprzez E-Mail i Skype. 

**Aktualnie poszukujemy**  
1. Doświadczonego architekta REST, który pomoże nam ulepszyć aktualny serwis (security, best practices ipt.).  
2. Doświadczonego administratora Jenkins. Mamy aktualnie skonfigurowany CI pipeline dla 3 projektów (OPW, [OPW AngularJS](https://github.com/marcintokarski/OtwartaPlatformaWyborczaFronted) jak i [OpenPKW POC_Kalkulator](https://github.com/openpkw/PocKalkulatorWyborczyHtml)) ale na pewno da się to zrobić o wiele lepiej.  
3. Doświadczonego administratora kontenera Java EE GlassFish 4.1 bądź WildFly 8.2.0. Celem jest konfiguracja produkcyjnego clustera.  
4. Grafika do opracowania ikonografiki (przyciski) programu, tła, liternictwa, oraz głównego symbolu znaku graficznego / logo programu.  

# Linki

| Element  | Link  |
| ------------- | ------------- |
| Tablica Trello   | https://trello.com/b/hKes4OCP/otwarta-platforma-wyborcza  |
| Backend daily (Java EE)   | http://91.250.114.134:8080/opw/  |
| Frontend komisja daily (AngularJS) | http://91.250.114.134/ |
| Frontend wyniki daily (jQuery) | http://91.250.114.134/dashboard/ |

# Quickstart
1. MySQL skonfiguruj serwer do pracy w trybie UTF-8, jako engine InnoDB    
  * `default-storage-engine = InnoDB`  
  * `collation-server = utf8_general_ci`  
  * `character-set-server = utf8`  
2. MySQL dodaj użytkownika opw zgodnie z definicją w `glassfish-resources.xml`
3. MySQL Workbench wykonaj import bazy (opcja Forward Engineer)
4. GlassFish wykonaj import `glassfish-resources.xml` 
5. mvn clean install i deploy na serwer


##Wymagane oprogramowania
* JDK7 (migracja na JDK8 ASAP)
* IDE z obsługą Maven 3
* Kontener JEE w profilu **full** (zależność JavaMail) (preferuje i polecam GlassFish 4)
* Wymagane JNDI resources 
  * GlassFish pozwala na import definicji z pliku XML `setup/glassfish-resources.xml`
  * `jdbc/opw` dla bazy danych (plik XML - pełna definicja)
  * `mail/opw` dla JavaMail (plik XML - brakuje loginów, haseł jak i adresów)
* MySQL 5 na localhost (w pliku .mwb jest ustawiona min. kompatybilność na 5.5) 
  * url, port, login i hasło są w pliku `persistance.xml`
* MySQL Workbench
  * baza danych jest definiowana jako diagram ERM
  * synchronizacja z serwerem poprzez opcje Forward Engineer (CTRL+G)


# Proces

**Przygotowanie wyborów**
1. Administrator definiuje / importuje oficjalną listę Komisji Okręgowych  (51)
2. Administrator definiuje / importuje oficjalną listę Kandydatów (11)
3. Administrator definiuje / importuje oficjalną listę Komisji Obwodowych (około 27 000) 
4. Administrator zakłada / importuje konta użytkowników (wolentariusze, mężowie zaufania, około 25 000)
5. System automatycznie rozsyła hasła użytkowikom, wraz z linkiem do aktywacji konta, na podany adres E-Mail.  
6. Administrator systemu ma możliwość edycji i weryfikacji kont użytkownków wraz ich danymi (możliwa fluktuacja użytkowników tuż przed wyborami)

**Dzień wyborczy - perspektywa użytkownika**
1. Użytkownik loguje się na stronie OPW i wybiera z listy jedną z przypisanych mu Komisji Obwodowych. 
2. Użytkownik widzi na okrenie dokładne informacje dotyczące wybranej Komisji Obwodowej. 
3. Użytkownik wpisuje dane / liczby wyborcze z protokołu do aplikacji OPW. 
4. Walidacja protokołu po stronie klienta (JavaScript/HTML5) dla błędów twardych.
5. Użytkownik wysyła dane/liczby wyborcze na serwer OPW. 

**Dzień wyborczy - perspektywa serwera**
1. Liczby wyborcze spływają na serwer. 
1. Każdy protokół jest walidowany, w przypadku identyfikacji błędu miękkiego protokół protokół zostanie otagowany. 
1. Protokoły są zapisywane w bazie danych. 
1. Aktualny wynik wyborów jest publikowany co 5 minut. 


**Dzień wyborczy / perspektywa gościa**  
1. Gość wchodzi na stronę główną aplikacji OPW-dashboard
1. OPW/dashboard zapewnia dostęp do aktualnych wyników w skali kraju jak i gminy. 

# Specyfikacja

## Grupy użytkowników 
1. Administrator (admin)
2. Użytkownik (user)
3. Gość (guest)


## Grupy użytkowników (docelowa architektura) 
1. Administrator (admin) 
2. Koordynator Gminy  (odpowiedzialny za operatorów)
3. Operator Informatyczny  (najczęściej informatyk, może być odpowiedzialny za kilka komisji)
4. Przewodniczący Komisji 
5. Gość (guest) - obywatel który odwiedza strone aby sprawdzić wynik wyborów

## Risk & Issue Logs
1. Wysyłanie protokołów i zakonczenie liczenia głosów w 25000 komisjach zazwyczaj konczy się o tej samej porze +/- 15 min w przypadku prostych wyborów jakimi są Wybory Prezydenckie Potrzebna Analiza wydajnosciowa serwerów  w tym (SQL, Moc Obliczeniowa maszyny oraz sama przepustowość łącza i-net). Zastanowić się nad modułem synchronizacji otrzymywania wyników.

2. Goście (wyborcy), którzy będą chcieli sprawdzić niezależne wyniki na stronie www - mogą spowodować zawieszenie się wydajnościowe serwera, gdy usługa będzie cieszyć sie bardzo dużą popularnoscią. Do rozważenia wprowadzenie modułu logowania na gości i ograniczenie ilości połaczeń dla danego gościa.   

## Appendix Features
1. Moduł generowania umów zleceń z operatorami oraz wypaty diet dla członków komisji wraz z wstępnie wypełnionym PIT-R
2. Import / eksport danych operatorów i członków komisji z/do pliku XLS 
3. Moduł "Przypominajek" dla operatorów i członków komisji wyborczych mowiący o poprawnym przeprowadzeniu procedury wyborów np. Wywieszeniu Obwieszczeń, Wydrukowaniu w należytej ilosci kopii protokołów, Zabezpieczeniu Brudnopisów, Zgraniu na zewnętrzny nośnik elektronicznej wersji protokołu, Przekazanie protokołu fizcznie po wydrukowaniu do KBW itp itd etc.   


## Software stack 
### Backend 
1. Java EE 7 (GlassFish 4, JPA2, CDI, EJB, JSF 2.2 (PrimeFaces 5.1), JAX-RS, JAAS, JavaMail)
2. MySQL 5.5 (UTF8, InnoDB, MySQL Workbench)
3. REST
4. HTML5 
5. CSS3
6. Maven 3

### Frontend 
1. HTML5
2. JavaScript (AngularJS)
3. CSS3
4. Bootstrap 


## REST 
Proces wgrywania protokołu z perspektywy.  
1. GET Zalogowanie  
2. GET Lista komisji obwodowych za które użytkownik jest odpowiedzialny  
3. GET Detale wybranej komisji obwodowej (dane podstawowe, lista kandydatów, lista protokołów)  
4. POST Upload liczb wyborczych  
5. GET Wylogowanie  

### Headers 
Jako prefix `X-OPW`  
* `X-OPW-login`  
* `X-OPW-password`  
* `X-OPW-token`  


## Roadmap
Plan implementacji

### Wersja 0.1 [wydana 2015.03.24] 
* [DONE] Definicja bazy danych
* [DONE] Funkcjonalność CRUD(Create Remove Update Delete) w przeglądarce dla obiektów
  * user (+ generowanie hasła )
  * kandydat
  * komisja okręgowa
  * komisja obwodowa

### Wersja 0.2 [wydana 2015.03.29] 
* [DONE] Wysyłanie E-Maili z loginem i hasłem
* [DONE] Użytkownik może zarejestrować numer telefonu dla funkcji protokół SMS
* [DONE] Konfiguracja Jenkins i działający CI
* [DONE] Definicja i implementacja interfejsu REST 
* [DONE] Kolejne funkcje dla administratora 
  * reset hasła użytkownika 
  * aktywowanie i deaktywowanie konta użytkownika
* [DONE] Definicja szablonu E-Mail

### Wersja 0.3.0 [wydana 2015.04.03] 
* [DONE] OPW-T-4 : Generowanie E-Mail poprzez szablony FreeMarker
* [DONE] Integracja TestNG i Mockito 
* [DONE] Integracja mvn release 

### Wersja 0.4.0 [wydana 2015.04.12] 
* [DONE] OPW-T-5 : Rozbicie kolumny `name` w bazie danych na `firstname` i `lastname` 
* [DONE] OPW-A-8 Możliwość zamknięcia listy kandydatów. 
* [DONE] OPW-A-3 Import CSV dla encji: komisja okręgowa 
* [DONE] OPW-T-5 : Definicja struktury plików CSV Komisji Obwodowych
* [DONE] Migracja repozytoriów do organizacji
* [DONE] Wykonanie mockup serwisów REST dla klientów

### Wersja 0.5
* OPW-T-6 Autoryzacja i autentyfikacja na bazie JAAS
* [OPW-A-2](https://trello.com/c/z6dxd86e/16-opw-a-2-import-komisji-obwodowych-z-pliku-csv) Import CSV dla Komisji Obwodowych
* [OPW-A-6](https://trello.com/c/z00oQvGg/15-opw-a-6-import-kont-u-ytkownikow-z-pliku-csv) Import kont użytkowników z pliku CSV
* [WiP] REST API dla klienta AngularJS 
* [WiP] REST API dla klienta jQuery 
* [WiP] [OPW-U-6](https://trello.com/c/7TqIlwrd/17-opw-u-6-aktywacja-konta) aktywacja konta  
* Pełna integracja z aplikacją OPW-client
* Pełna integracja z aplikacją OPW-dashboard

### Wersja 0.6
* [WiP] Definicja infrastruktury na nadchodzące wybory
* [WiP] Definicja szablonu SMS

### Wersja 0.8
* Podbieranie protokołów przesłanych na skrzynke pocztową
* Automatyczne parsowanie protokołów ze skrzynki pocztowej
  * import poprawnych protokołów
  * tagowanie błędnych protokołów  

### Wersja 1.0
* Backend w Java EE
* Maski administratora w JSF
* Maski użytkowników w HTML - AngularJS + REST 
* Wyniki wyborów w HTML - jQuery + REST
