# User story - kompletna lista 
Rozróżniamy dwa warianty OPW: prosty (na wybory prezydenckie 2015) i rozszerzony. Pojedyncze user story organizujemy z perspektywy użytkownika.  
Schemant nazewnictwa: OPW-{perspektywa: A, U, G, O, K}-{numer}. 


## Wariant prosty Prezydent 2015 
Jest to lista minimalnych wymagań by obsłużyć nadchodzące wybory. 

### Administrator
* OPW-A-1 : Jako administrator mogę zalogować się do systemu i uzyskać dostęp do stron administracyjnych
* OPW-A-2 : Jako administrator definiuję / importuję komisje obwodowe (nr komisji, adres, przynależność do komisji okręgowej)
* OPW-A-3 : Jako administrator definiuję / importuję komisje okręgowe (nr komisji oraz adresy)
* OPW-A-4 : Jako administrator jestem w stanie dokonać wirtualnego podziału państwa na okręgi i obwody wyborcze 
* OPW-A-5 : Jako administrator jestem w stanie dodać pojedyncze konto użytkownika w przeglądarce 
* OPW-A-6 : Jako administrator jestem w stanie wykonać import listy użytkowników z pliku CSV
* OPW-A-7 : Jako administrator chcę wykonać import komisji okręgowych bezpośrednio z pliku CSV 
* OPW-A-8 : Jako administrator chcę, po opublikowaniu przez PKW oficjalnej listy kandydatów, zamknąć listę kandydatów (przejść w tryb read-only) w OPW. 
* OPW-A-9 : Jako administrator chcę zarządzać listą Komisji Obwodowych przypisanych do konkretnego użytkownika. 

### Użytkownik 
* OPW-U-1 : Jako użytkownik mogę się zalogować i wylogować
* OPW-U-2 : Jako użytkownik widzę po zalogowaniu się listę moich komisji obwodowych
* OPW-U-3 : Jako użytkownik widzę po wybraniu komisji podstawowe informacje: listę kandydatów, listę protokołów jak i formularz liczb wyborczych
* OPW-U-4 : Bezpośrednia walidacja błędów twardych w przeglądarce
* OPW-U-5 : Upload liczb wyborczych do serwera OPW
* OPW-U-6 : Aktywacja konta
* OPW-U-7 : Jako użytkownik, mogę wpisać ręcznie PKW ID Komisji Obwodowej, której liczby wyborcze chciałbym wgrać do systemu. 


### Gość

* OPW-G-1 : Jako gość jestem w stanie wejść na stronę www i wyświetlić wyniki z danej komisji wyborczej / gminy / powiatu / okręgu / województwa / Polski.
* OPW-G-2 : Jako gość mam limitowany dostęp do serwera i możliwość wyswietlania wyników aby nie przeciążyć serwera  
* OPW-G-3 : Jako gość mogę założyć nowe konto w systemie OPW.  

### Technologia
* OPW-T-1 : Wykonanie dokumentacji REST API w swagger.io 
* OPW-T-2 : Integracja SFL4J jako loggera
* OPW-T-3 : Migracja z EclipseLink na Hibernate +envers 
* OPW-T-4 : Generowanie E-Mail poprzez szablony FreeMarker
* OPW-T-5 : Rozbicie kolumny `name` w bazie danych na `firstname` i `lastname` 
* OPW-T-6 : Autoryzacja i autentykacja na bazie JAAS
* OPW-T-7 : Logowanie dla REST i JSF
* OPW-T-8 : Serwis REST pozwalający na rejestrację nowego użytkownika. 
* OPW-T-9
* OPW-T-10








