# Otwarta Platforma Wyborcza
Otwarta Platforma Wyborcza (OPW) to oprogramowanie klasy enterprise, którego podstawowym zadaniem jest niezależna i obiektywna weryfikacja wyników wyborów prezydenckich 2015. Celem projekt OPW nie jest kompletna implementacja wymagań sprecyzowanych przez PKW w ramach projektu PW2 (Platforma Wyborcza 2).   

Wersja daily OPW jest dostępna tutaj http://91.250.114.134:8080/opw/

# Quickstart
1. MySQL skonfiguruj serwer do pracy w trybie UTF8, jako engine InnoDB
2. MySQL dodaj użytkownika opw zgodnie z definicją w persistence.xml
3. MySQL Workbench wykonaj import bazy (opcja Forward Engineer)
4. GlassFish wykonaj import glassfish-resources.xml 
5. mvn clean install i deploy na serwer


##Wymagane oprogramowania
* JDK7 (migracja na JDK8 ASAP)
* IDE z obsługą Maven 3
* Kontener JEE (preferuje i polecam GlassFish 4, profil nie ma znaczenia, aplikacja działa w Web jak i Full)
  * aplikacja wymaga JNDI resource dla bazy danych, GlassFish pozwala na import definicji z pliku XML setup/glassfish-resources.xml 
* MySQL 5 na localhost (w pliku .mwb jest ustawiona min. kompatybilność na 5.1) 
  * url, port, login i hasło są w pliku persistance.xml
* MySQL Workbench
  * baza danych jest definiowana jako diagram ERM
  * synchronizacja z serwerem poprzez opcje Forward Engineer (CTRL+G)


# Proces
**Przygotowanie do wyborów**  
1) Administrator definiuje / importuje komisje okręgowe i należące do nich komisje obwodowe (nr komisji oraz adresy)

2) Administrator definiuje/ importuje koordynatorów wyborów (imie, nazwisko, telefon, mail, przypisane obwody  najczesciej gmina badz dzielnica ) 

3) Administrator zakłada konta koordynatorom i łączy je z odpowiednimi komisjami i obwodami

4) Administrator zakłada konta operatorom

5) Administrator zaklada konta użytkownikom (przewodniczącym komisji obwodowych badz/i wolentariuszom, męzom zaufania)

6) Operatorzy zbierają dane od uzytkownków ( imie, nazwisko, telefon, mail,  z jakiej partii , data powołania, Pesel,    Czy nie kandydują, nr Komisji ,Adres komisji)

7) Koordynator  wyborów definiuje/importuje składy komisji lokalnych otrzymanych od operatorów (przypisuje użytkownków  do komisji

7.1) System automatycznie wysyła link do aktywacji konta, login i hasło użytkownikom na podany adres E-Mail 

7.2) Użytkownik aktywuje konto w OPW  

PERSPEKTYWA KOORDYNATORA

8) Koordynator wprowadza i importuje do systemu informacje o operatorach. Najlepiej import z XLS ( imie, nazwisko,  telefon,mail, uwagi )

8.1) Koordynator przekazuje operatorom otrzymane od Administratora hasła dostepów dla uzytkowków 

PERSPEKTYWA OPERATORA

9) Koordynator wprowadza i importuje do  systemu informacje o użytkownkach. Najlepiej import z XLS ( imie, nazwisko, telefon,mail, uwagi )

**Dzień wyborczy import danych**  
PERSPEKTYWA UŻYTKOWNIKA

10) Użytkownik loguje się na stronie (maski w paper browser)  
11) Użytkownik wpisuje dane z protokołu (maski w paper browser)  
12) Użytkownik wysyła dane  
12.1) Walidacja po stronie klienta (JavaScript/HTML5) dla błędów twardych  
 
PERSPEKTYWA SERWERA  
13) Walidacja po stronie serwera JSR323 m.in. dla błędów miękkich i tagowanie protokołów  
14) Import danych  

**Dzień wyborczy wyniki**  
15) Użytkownik bądź/igość wchodzi na stronę główną, aktualne wyniki (agregowane np. co 5min) są widoczne

16)Uzytkownik po wysłaniu protokołu musi zostać poinformowany o przesyłaniu go i odebraniu przez serwer.


# Specyfikacja

## Grupy użytkowników 
1. Administrator (admin)
2. Użytkownik (user)
3. Gość (guest)


## Grupy użytkowników (docelowa architektura) 
1. Administrator (admin) 
2. Koordynator Wyborów (odpowiedzialny za operatorów)
3. Operator Wyborów (najczęściej informatyk, może być odpowiedzialny za kilka komisji)
4. Użytkownik (mąz zaufania, wolentariusz bądz/i przewodniczący
5. Gość (guest) - obywatel który odwiedza strone aby sprawdzić wynik wyborów

## Risk & Issue Logs
1. Wysyłanie protokołów i zakonczenie liczenia głosów w 25000 komisjach zazwyczaj konczy się o tej samej porze +/- 15 min. Potrzebna Analiza wydajnosciowa serwerów  w tym (SQL, Moc Obliczeniowa maszyny oraz sama przepustowość łącza i-net)

## Appendix Features
1. Moduł Generowania  umów zleceń z operatorami oraz diet dla członków komisji wraz z wstepnie wypełnionym PIT-R
2. Import / eksport danych operatorów i członków komisji z pliku XLS 
3. Moduł Przypominajek dla operatorów i czlonków komisji wyborczych mowiący o poprawnym przeprowadzeniu procedury wyborów np. Wywieszeniu Obwieszczen, Wydrukowaniu w nalezytej ilosci kopii protokołow, Zabezpieczeniu Brudnopisów, Zgraniu na zew nosnik elektronicznej wersji protokolu, Przekazanie protokolu fizcznie po wydrukowaniu do KBW itp itd etc.   


## Software stack
1. Java EE 7 (GlassFish 4, JPA2, CDI, EJB, JSF 2.2 (PrimeFaces 5.1), JAX-RS, JAAS, JavaMail)
2. MySQL 5.5 (UTF8, InnoDB, MySQL Workbench)
3. REST
4. HTML5 
5. CSS3
6. Maven 3

## Roadmap
Plan implementacji

### Wersja 0.1 [wydana 2015.03.24] 
* Definicja bazy danych
* Funkcjonalność CRUD(Create Remove Update Delete) w przeglądarce dla obiektów
  * user (+ generowanie hasła )
  * kandydat
  * komisja okręgowa
  * komisja obwodowa

### Wersja 0.2
* Wysyłanie E-Maili z loginem i hasłem
* Użytkownik może zarejestrować numer telefonu dla funkcji protokół SMS
* [DONE] Konfiguracja Jenkins i działający CI
* Definicja i implementacja interfejsu REST 
* Import CSV/KLK dla następujących encji: user, komisja obwodowa, komisja okręgowa 
* Kolejne funkcje dla administratora 
  * reset hasła użytkownika 
  * aktywowanie i deaktywowanie konta użytkownika
* Definicja szablonu SMS
* Definicja szablonu EMail
* Definicja masek UI dla klienta HTML5/CSS3 

### Wersja 0.3
* Możliwość zamknięcia listy kandydatów. 
* Autoryzacja i autentyfikacja na bazie JAAS
* Podbieranie protokołów przesłanych na skrzynke pocztową
* Automatyczne parsowanie protokołów ze skrzynki pocztowej
  * import poprawnych protokołów
  * tagowanie błędnych protokołów  
Definicja architektury na nadchodzące wybory


### Wersja 0.5
* Aktualne wyniki wyborów są dostępne na stronie.


### Wersja 0.6
* Frontend bezpośrednio w HTML / JavaScript / REST

### Wersja 0.8
* Aktualizacja Dashboard

### Wersja 1.0
* Backend w Java EE
* Maski administratora w JSF
* Maski użytkowników w HTML + REST 
