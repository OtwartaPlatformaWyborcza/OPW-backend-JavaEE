# Otwarta Platforma Wyborcza
Otwarta Platforma Wyborcza (OPW) to oprogramowanie klasy enterprise, którego podstawowym zadaniem jest niezależna i obiektywna weryfikacja wyników wyborów prezydenckich 2015. Celem projektu OPW nie jest kompletna implementacja wymagań sprecyzowanych przez PKW w ramach projektu PW2 (Platforma Wyborcza 2).   

Wersja daily OPW jest dostępna tutaj http://91.250.114.134:8080/opw/

# Quickstart
1. MySQL skonfiguruj serwer do pracy w trybie UTF-8, jako engine InnoDB  
  * ```default-storage-engine = InnoDB```  
  * ```collation-server = utf8_general_ci```  
  * ```character-set-server = utf8```  
2. MySQL dodaj użytkownika opw zgodnie z definicją w glassfish-resources.xml
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
1. Administrator definiuje / importuje komisje obwodowe (nr komisji oraz adresy komisji)  
2. Administrator definiuje/ importuje koordynatorów wyborów (imie, nazwisko, telefon, mail, przypisane komisje obwodowe najczesciej gmina badz dzielnica ) - funkcja docelowa zaplanowa w przyszlosci.  
3. Administrator zakłada konta koordynatorom i łączy je z odpowiednimi komisjami i obwodami - funkcja docelowa zaplanowa w przyszlosci.  

4) Koordynator wyborów zakłada konta operatorom -  funkcja docelowa zaplanowa w przyszlosci.

5) Administrator zaklada konta użytkownikom (wolentariusz bądz/i męzom zaufania)  
5a) Kordynator wybórów zaklada konta operatorom i przewodniczącemu komisji - funkcja docelowa zaplanowa w przyszlosci.  

6)  Administrator rozsyła hasła uzytkowikom.  
6a) Administrator generuje i rozsyła certyfikaty SSL/TSL koordynatorom - funkcja docelowa zaplanowa w przyszlosci.  

7)  Administrator zbiera dane  uzytkownika badz/i importuje je  z XLS  (Imie, nazwisko, mail , telefon, nr komisji )  
7a) Koordynator zbiera dane od uzytkownków ( imie, nazwisko, telefon, mail,  z jakiej partii , data powołania, Pesel,     Walidacja Czy nie kandydują, nr Komisji ,Adres komisji) - - funkcja docelowa zaplanowa w przyszlosci.

8) Koordynator wyborów definiuje/importuje składy komisji lokalnych i przypisuje do nr komisji - funkcja docelowa w przyszlosci  
8a) Koordynator wyborów definiuje/importuje operatorów informatycznnych funkcja docelowa w przyszlosci

9) System automatycznie wysyła link do aktywacji konta, login i hasło użytkownikom na podany adres E-Mail  
9a) System generuje hasła dostepu dla operatorow i przewodniczących komisji którzy proszą po zalogowaniu sie o wydanie certyfikatu -  funkcja docelowa w przyszlosci  
9b)  System po zatwierdzeniu zgłoszenia przez Administratora udostepnia certyfikat do pobrania operatorom i przewodniczacym -  funkcja docelowa w przyszlosci  

10) Administrator systemu ma mozliwosc edycji, weryfikacji kont uzytkownków wraz ich danymi.


**Dzień wyborczy**

11 Użytkownik loguje się na stronie OPW i automatycznie zostaje przypisany do prawidlowej komisji  
12) Uzytkownik drukuje pusty nie wypełniony protokól - funkcja docelowa w przyszlosci  
13) Użytkownik wpisuje dane z protokołu (maski w paper browser)  
14) Uzytkownik ma mozliwosc poprawienia protokołu  
15) Uzytkownik ma mozliwosc wydrukowania protokolu  
15) Uzytkownik ma mozliwosc zapisania/wczytania protokolu na zewnetrznym nosniku.  
16) Użytkownik wysyła dane  
17) Walidacja po stronie klienta (JavaScript/HTML5) dla błędów twardych i miekkich.   
18) Raport błedów/ostrzezen dla przewodniczacych komisji - funkcja docelowa w przyszlosci.  

 
PERSPEKTYWA SERWERA  
  
18) Import/ otrzymanie danych.  
19) Sprawdzenia certyfikatów i uwierzytelnien - funcja docelowa w przyszlosci  
20) Potwierdzenie otrzymania danych dla uzytkownika (np mail)  
21) Panel administracyjny dla Administratora jakie dane z których komisji spłyneły wraz z warningami.  

**Dzień wyborczy wyniki**  
22) Użytkownik wchodzi na stronę główną, dostaje aktualne wyniki  w podziale na komisje (agregowane np. co 5min)  
22) Podział po kodzie Teryt, Wojewódzwo, Gmina, Komisja  
23) Frekwencja - wysłanie liczby osob uprawnionych i wydanych kart.  



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
