# Burza mózgów
W naszej Burzy mózgów [Wiki](http://pl.wikipedia.org/wiki/Burza_m%C3%B3zg%C3%B3w) zbieramy pomysły na przyszłość. 

1. (Przemek) Na wydruku protokołu wyborów dołożyc QR Code z zawartą informacją dotyczącą liczb z tego konkretnego protokołu. Zeskanowanie QR codu pozwala na natychmiastowe otrzymanie wyniku obliczeń Komisji Wyborczej oraz graficznego obrazu protokołu.
2. (Przemek) Archiwizacja wyników. 


### Wersja rozszeżona
1. Sprawdzenie certyfikatów i uwierzytelnień operatorów i przewodniczących - funcja docelowa w przyszłości
2. Import Danych do serwera (protokołów)
3. Potwierdzenie otrzymania danych dla użytkownika (np wysłanie maila)
4. Panel administracyjny dla Administratora jakie dane z których komisji spłyneły wraz z warningami (selecty SQL + maski w paper browser ) 


**Przygotowanie wyborów ( funkcjonalnoć docelowa )**

1. Administrator definiuje/ importuje koordynatorów wyborów (imie, nazwisko, telefon, mail, przypisane komisje obwodowe najczęsciej gminne bądź dzielnicowe)
2. Administrator zakłada konta koordynatorom i łączy je z odpowiednimi komisjami i obwodami
3. Kordynator wybórów zakłada konta operatorom i przewodniczącemu komisji - Import XLS
4. Administrator generuje i rozsyła certyfikaty SSL/TSL koordynatorom
5. Koordynator wyborów definiuje/importuje składy komisji lokalnych i przypisuje do nr komisji
6. System generuje hasła dostepu dla operatorow i przewodniczących komisji, którzy proszą po zalogowaniu się o wydanie certyfikatu 


1.  ***System po zatwierdzeniu zgłoszenia przez Administratora udostepnia certyfikat do pobrania operatorom i przewodniczacym -  funkcja docelowa w przyszłośći***
4.  Użytkownik ma możliwość wydrukowania protokołu (nie wypełnionego także)
5.  Użytkownik ma możliwość zapisania/wczytania protokołu na/z zewnetrznego nośnika (CD, USB)
8. Użytkownik otrzymuje powiadomienie o odebraniu protokołu przez serwer np po przez mail
9.  ***Raport błedów/ostrzeżeń dla przewodniczacych komisji - funkcja docelowa w przyszlości.***

## Risk & Issue Logs
1. Wysyłanie protokołów i zakonczenie liczenia głosów w 25000 komisjach zazwyczaj konczy się o tej samej porze +/- 15 min w przypadku prostych wyborów jakimi są Wybory Prezydenckie Potrzebna Analiza wydajnosciowa serwerów  w tym (SQL, Moc Obliczeniowa maszyny oraz sama przepustowość łącza i-net). Zastanowić się nad modułem synchronizacji otrzymywania wyników.

2. Goście (wyborcy), którzy będą chcieli sprawdzić niezależne wyniki na stronie www - mogą spowodować zawieszenie się wydajnościowe serwera, gdy usługa będzie cieszyć sie bardzo dużą popularnoscią. Do rozważenia wprowadzenie modułu logowania na gości i ograniczenie ilości połaczeń dla danego gościa.   

## Appendix Features
1. Moduł generowania umów zleceń z operatorami oraz wypaty diet dla członków komisji wraz z wstępnie wypełnionym PIT-R
2. Import / eksport danych operatorów i członków komisji z/do pliku XLS 
3. Moduł "Przypominajek" dla operatorów i członków komisji wyborczych mowiący o poprawnym przeprowadzeniu procedury wyborów np. Wywieszeniu Obwieszczeń, Wydrukowaniu w należytej ilosci kopii protokołów, Zabezpieczeniu Brudnopisów, Zgraniu na zewnętrzny nośnik elektronicznej wersji protokołu, Przekazanie protokołu fizcznie po wydrukowaniu do KBW itp itd etc.   
