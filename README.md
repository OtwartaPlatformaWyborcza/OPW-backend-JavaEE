# Otwarta Platforma Wyborcza
Otwarta Platforma Wyborcza (OPW) to oprogramowanie klasy enterprise, którego podstawowym zadaniem jest niezależna i obiektywna weryfikacja wyników wyborów prezydenckich 2015. Celem projekt OPW nie jest kompletna implementacja wymagań sprecyzowanych przez PKW w ramach projektu PW2 (Platforma Wyborcza 2).   

# Quickstart


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
1) Administrator definiuje / importuje komisje okręgowe i należące do nich komisje obwodowe.  
2) Administrator zakłada konta użytkownikom i łączy je z odpowiednimi komisjami  
2.1) System automatycznie wysyła link do aktywacji konta, login i hasło użytkownikom na podany adres E-Mail  
2.2) Użytkownik aktywuje konto w OPW  

**Dzień wyborczy import danych**  
perspektywa użytkownika  
3) Użytkownik loguje się na stronie (maski w paper browser)  
4) Użytkownik wpisuje dane z protokołu (maski w paper browser)  
5) Użytkownik wysyła dane  
5.1) Walidacja po stronie klienta (JavaScript/HTML5) dla błędów twardych  
 
perspektywa serwera  
5.2) Walidacja po stronie serwera JSR323 m.in. dla błędów miękkich i tagowanie protokołów  
6) Import danych  

**Dzień wyborczy wyniki**  
7) Użytkownik bądź gość wchodzi na stronę główną, aktualne wyniki (agregowane np. co 5min) są widoczne


# Specyfikacja

## Grupy użytkowników 
1. Administrator (admin)
2. Użytkownik (user)
3. Gość (guest)


## Grupy użytkowników (docelowa architektura) 
1. Administrator (admin) 
2. Koordynator Wyborów (odpowiedzialny za operatorów)
3. Operator Wyborów (najczęściej informatyk, może być odpowiedzialny za kilka komisji)
4. Gość (guest) - obywatel który odwiedza strone aby sprawdzić wynik wyborów


## Software stack
1. Java EE 7 (GlassFish 4, JPA2, JSF 2.2, JAX-RS)
2. MySQL 5
3. REST
4. HTML5 
5. CSS3
6. Maven 3

## Roadmap
Plan implementacji

### Wersja 0.1
* Definicja bazy danych
* Funkcjonalność CRUD w przeglądarce dla obiektów
  * user (+ generowanie hasła )
  * kandydat
  * komisja okręgowa
  * komisja obwodowa


### Wersja 0.2
* Wysyłanie E-Maili z loginem i hasłem
* Konfiguracja Jenkins i działający CI

### Wersja 0.3
* Definicja interfejsu REST

### Wersja 0.5
* Implementacja interfejsu REST
* Dashboard

### Wersja 0.6
* Frontend bezpośrednio w HTML / JavaScript / REST

### Wersja 0.8
* Aktualizacja Dashboard

### Wersja 1.0
* Backend w Java EE
* Maski administratora w JSF
* Maski użytkowników w HTML + REST 
