import math
from integraisNewtonCotes import iterar

raiz = math.sqrt

def intSegundaSimples(f, a, b, ec, ei):
    x = lambda s: (a + b)/2 + (b - a)*math.tanh(s)/2
    dx = lambda s: (b - a)/(2 * (math.cosh(s))**2)

    ft = lambda s: f(x(s)) * dx(s)

    I, Ip = 0, 0
    t = math.inf
    inc = 1
    c = 0

    while t > ec:
        c += inc
        I = Ip

        passou = False
        while passou != True:
            try:
                Ip, div = iterar(ft, -c, c, ei, 3, 1)
                passou = True
            except ZeroDivisionError:
                inc /= 2

                if inc == 0:
                    break
                else:
                    c -= inc
            except OverflowError:
                print(I, c)

        t = abs(Ip - I)
    
    return I, c - inc

def intSegundaDupla(f, a, b, ec, ei):
    x = lambda s: (a + b)/2 + (b - a)*math.tanh(math.pi*math.sinh(s)/2)/2
    dx = lambda s: ((b - a)/2) * ((math.pi/2) * ((math.cosh(s))/(math.cosh(math.pi*math.sinh(s)/2))**2))

    ft = lambda s: f(x(s)) * dx(s)

    I, Ip = 0, 0
    t = math.inf
    inc = 1
    c = 0

    while t > ec:
        c += inc
        I = Ip

        passou = False
        while passou != True:
            try:
                Ip, div = iterar(ft, -c, c, ei, 3, 1)
                passou = True
            except ZeroDivisionError:
                inc /= 2

                if inc == 0:
                    break
                else:
                    c -= inc
            except OverflowError:
                print(I, c)

        t = abs(Ip - I)
    
    return I, c - inc

fTeste = lambda x: 1/(x)**(1/2)
f1 = lambda x: 1/(x**2)**(1/3)
f2 = lambda x: 1/raiz(4 - x**2)

print(intSegundaSimples(fTeste, 0, 1, 10**-6, 10**-6))
print(intSegundaDupla(fTeste, 0, 1, 10**-6, 10**-6))

# print(intSegundaSimples(lambda x: 1/((x**2)**(1/3)), -1, 1, 10**-4, 10**-4)) #NÃO CONVERGE

print(intSegundaSimples(f1, -1, 0, 10**-6, 10**-6)[0] + intSegundaSimples(f1, 0, 1, 10**-6, 10**-6)[0])
print(intSegundaSimples(f1, -1, 0, 10**-6, 10**-6))
print(intSegundaDupla(f1, -1, 0, 10**-6, 10**-6)[0] + intSegundaDupla(f1, 0, 1, 10**-6, 10**-6)[0])
print(intSegundaDupla(f1, -1, 0, 10**-6, 10**-6))

print(intSegundaSimples(lambda x: 1/raiz(4 - x**2), -2, 0, 10**-6, 10**-6))
print(intSegundaDupla(lambda x: 1/raiz(4 - x**2), -2, 0, 10**-6, 10**-6))