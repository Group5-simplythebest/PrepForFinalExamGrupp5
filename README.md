Ni arbetar på ett företag som hanterar stora mängder användardata. 
Er uppgift är att bygga en liten applikation som kan hantera en lista av användare, där ni kan söka och filtrera användarna baserat på vissa kriterier. 
Applikationen ska utnyttja streams, generics, lambdas, annotations, och reflection för att vara så flexibel och dynamisk som möjligt.

Modellera Användarobjektet (Person) med Annotations
För att hantera användardata, börja med att skapa en klass Person som representerar en användare med följande fält:
- String name
- int age
- String email
- String role

Skapa en anpassad annotation @SensitiveData som markerar ett fält som känsligt, t.ex. email. Detta kommer att användas för att dölja denna information i vissa vyer.

2. Använd Generics för Filterfunktioner
Skapa en klass UserFilter<T> där ni implementerar generiska metoder för att filtrera en lista av användare.
Metoderna ska ta emot olika predikat som kriterier för att filtrera listan. Använd lambdas för att göra filtreringen flexibel och kraftfull.

4. Streams och Lambdas för Söknings- och Sorteringsfunktioner
Använd streams och lambdas för att implementera följande funktioner:
Sökning efter personer baserat på namn.
Sortering av personer efter ålder.

4. Dölja Känslig Information med Reflection
Skapa en metod printPersonInfo(Person person) som skriver ut information om en Person. Använd reflection för att kontrollera om ett fält är markerat med @SensitiveData och ersätt dess värde med t.ex. **** om det är känsligt.

5. Huvudmetod och Testning
Skapa en huvudklass som:
Skapar en lista av Person-objekt.
Använder UserFilter och lambdas för att filtrera och söka användare.
Använder printPersonInfo för att skriva ut användardata där känslig information döljs.
