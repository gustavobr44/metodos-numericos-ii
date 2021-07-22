from integraisGaussEspeciais import integrar
import math

f1 = lambda x: (2*x)**3 #Resposta 0, 48, 0
f2 = lambda x: math.cos(4*x) #Resposta 0.0324636, 0.058824, -1.24768
f3 = lambda x: (math.sin(2*x) + 4*(x**2) + 3*x)**2 #Resposta 34.0278, 547.17, 46.0524
f4 = lambda x: (3*x**3 - 56*x**2)**2 #Resposta 4198.72, 41424, 3703.3

f = [f1, f2, f3, f4]

for i in range(len(f)):
    print("Cálculo da integral da função f", i + 1, ":", sep='')

    print("  Gauss-Hermite:")
    for j in range(2, 5):
        I = integrar(f[i], j, 0)
        print("    ", j, " pontos: ", round(I, 7), sep="")

    print("  Gauss-Laguerre:")
    for j in range(2, 5):
        I = integrar(f[i], j, 1)
        print("    ", j, " pontos: ", round(I, 7), sep="")

    print("  Gauss-Chebyshev:")
    for j in range(2, 5):
        I = integrar(f[i], j, 2)
        print("    ", j, " pontos: ", round(I, 7), sep="")

    print()