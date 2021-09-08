from integraisNewtonCotes import iterar
import math

a = 0
b = 1
e = 10**-6

f1 = lambda x: (2*x)**3 #Resposta 2
f2 = lambda x: math.cos(4*x) #Resposta -0.1892006
f3 = lambda x: (math.sin(2*x) + 4*(x**2) + 3*x)**2 #Resposta 17.8764703
f4 = lambda x: (x + (3*x)**2 - math.cos(4*x**1.5) + math.e**(x/3)) #Resposta 4.62323

f = [f1, f2, f3, f4]

for i in range(len(f)):
    print("Cálculo da integral da função f", i + 1, " com erro de ", e, ":", sep='')

    print("  Filosofia Fechada:")
    for j in range(1, 5):
        I, div = iterar(f[i], a, b, e, j, 0)
        print("    Grau ", j, " com ", div, " divisões: ", round(I, 7), sep="")

    print("  Filosofia Aberta:")
    for j in range(1, 5):
        I, div = iterar(f[i], a, b, e, j, 1)
        print("    Grau ", j, " com ", div, " divisões: ", round(I, 7), sep="")

    print()