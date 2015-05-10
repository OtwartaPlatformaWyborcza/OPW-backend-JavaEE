
### GET /komisja/{pkwId}
Request headers:
```
X-OPW-login:username
X-OPW-token:fdf84e7bdbc4c22e5c0faae34d0819e9066bbcd02ff2f95561476f3ca32fb
```
Response:
```json
{  
   "pkwId":"106101-4",
   "name":"XV Liceum Ogólnokształcące im. Jana Kasprowicza",
   "address":"ul. Traktorowa 77, 91-204 Łódź",
   "okregowa":{  
      "pkwId":"14",
      "name":"Okręgowa Komisja Wyborcza Nr 14 w Łodzi"
   },
   "kandydatList":[  
      {  
         "pkwId":1,
         "firstname":"Janusz Ryszard",
         "lastname":"Korwin-Mikke",
         "glosow":0
      },
      {  
         "pkwId":2,
         "firstname":"Bronisław Maria",
         "lastname":"Komorowski",
         "glosow":0
      },
      ....
   ]
}
```

### GET /komisja/{pkwId}/protokol
Request headers:
```
X-OPW-login:username
X-OPW-token:fdf84e7bdbc4c22e5c0faae34d0819e9066bbcd02ff2f95561476f3ca32fb
```
Response:
```json
[  
   {  
      "id":2,
      "uploadTimestamp":"1430506141000",
      "ratedPositiv":0,
      "ratedNegativ":0
   },
   ....
]
```

### POST /komisja/{pkwId}/protokol
Request headers:
```
X-OPW-login:username
X-OPW-token:fdf84e7bdbc4c22e5c0faae34d0819e9066bbcd02ff2f95561476f3ca32fb
```
Request:
```json
{  
   "glosowWaznych":100,
   "glosujacych":10,
   "k1":12,
   "k2":3,
   "k3":13,
   "k4":12,
   "k5":16,
   "k6":12,
   "k7":18,
   "k8":15,
   "k9":18,
   "k10":19,
   "k11":15,
   "glosowNieWaznych":17,
   "kartWaznych":11,
   "uprawnionych":661
}
```

### GET /user/login
Request headers:
```
X-OPW-login:admin
X-OPW-password:pass
```

Response:
```json
{  
   "id":1,
   "fullname":"Administrator null",
   "firstname":"Administrator",
   "login":"admin",
   "token":"fdf84e7bdbc4c22e5c0faae34d0819e9066bbcd02ff2f95561476f3ca32fb",
   "sessionActive":true,
   "sessionTimeout":"1430583649544"
}
```

### GET /user/{userId}/obwodowa
Request headers:
```
X-OPW-login:username
X-OPW-token:fdf84e7bdbc4c22e5c0faae34d0819e9066bbcd02ff2f95561476f3ca32fb
```
Response:
```json
[  
   {  
      "id":4,
      "pkwId":"106101-4",
      "name":"XV Liceum Ogólnokształcące im. Jana Kasprowicza",
      "address":"ul. Traktorowa 77, 91-204 Łódź",
      "protokolCount":1
   },
   {  
      "id":5,
      "pkwId":"106101-5",
      "name":"Laboratorium Produkcji Ogrodniczej w Zespole Szkół Rzemiosła im. Jana Kilińskiego",
      "address":"ul. Liściasta 181, 91-220 Łódź",
      "protokolCount":0
   }
]
```


### GET /user/logout
Request headers:
```
X-OPW-login:username
X-OPW-token:fdf84e7bdbc4c22e5c0faae34d0819e9066bbcd02ff2f95561476f3ca32fb
```

### POST /user/register


### GET /user/available/{email}

Response:
- 200 if {email} is unique
- 409 if {email} is used
- 500 if serwer error


### GET /wynik/{wynikId}
Response:
```json
{  
   "uprawnionych":661,
   "glosujacych":10,
   "kartWaznych":11,
   "glosowNieWaznych":1,
   "glosowWaznych":100,
   "k1":12,
   "k2":3,
   "k3":13,
   "k4":12,
   "k5":16,
   "k6":12,
   "k7":18,
   "k8":15,
   "k9":18,
   "k10":19,
   "k11":15,
   "timestampCreated":"1430506141000",
   "ratedPositiv":0,
   "ratedNegativ":0
}
```

### GET /wynik/complete
Response:
```json
{  
   "obwodowa":12522,
   "obwodowaAll":24500,
   "frekwencja":20000000,
   "frekwencjaAll":40000000,
   "exportDate":"2015-05-02T18:00:53.719+02:00",
   "kandydatList":[  
      {  
         "pkwId":1,
         "firstname":"Janusz Ryszard",
         "lastname":"Korwin-Mikke",
         "glosow":140
      },
      {  
         "pkwId":2,
         "firstname":"Bronisław Maria",
         "lastname":"Komorowski",
         "glosow":202
      },
      ....
   ],
   "okregowaList":[  
      {  
         "okregowaName":"Okręgowa Komisja Wyborcza Nr 1 we Wrocławiu",
         "frekwencja":102728,
         "frekwencjaAll":750000,
         "obwodowa":743,
         "obwodowaAll":800
      },
      {  
         "okregowaName":"Okręgowa Komisja Wyborcza Nr 2 w Jeleniej Górze",
         "frekwencja":151489,
         "frekwencjaAll":750000,
         "obwodowa":38,
         "obwodowaAll":800
      },
      ....
   ]
}
```



Do testowania można użyć curl:
```
curl -G \
    -i \
    -H X-OPW-API-token:d171794c5c1f7a50aeb8f7056ab84a4fbcd6fbd594b1999bddaefdd03efc0591 \
    -H X-OPW-login:admin \
    -H X-OPW-token:bacd5d2591d75daaa4fe191fca0345a7129e5827b7d7dadaea8c74c3972cb7 \
    -H "Accept:application/json, text/javascript, */*; q=0.01" \
    http://91.250.114.134:8080/opw/service/wynik/complete
```

