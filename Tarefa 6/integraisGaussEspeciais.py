import math

raiz = math.sqrt

#-=-=-=-=-=-=-=Hermite=-=-=-=-=-=-=-

def intHermite2Pontos(f):
    x = [-1/raiz(2), 1/raiz(2)]
    w = [raiz(math.pi)/2, raiz(math.pi)/2]

    sum = 0

    for k in range(2):
        sum += f(x[k]) * w[k]
    
    return sum

def intHermite3Pontos(f):
    x = [-raiz(3/2), 0, raiz(3/2)]
    w = [raiz(math.pi)/6, 2*raiz(math.pi)/3, raiz(math.pi)/6]

    sum = 0

    for k in range(3):
        sum += f(x[k]) * w[k]
    
    return sum

def intHermite4Pontos(f):
    x = [-raiz((3/2) + raiz(3/2)), -raiz((3/2) - raiz(3/2)), raiz((3/2) - raiz(3/2)), raiz((3/2) + raiz(3/2))]
    w = [raiz(math.pi)/(12 + 4*raiz(6)), raiz(math.pi)/(12 - 4*raiz(6)), raiz(math.pi)/(12 - 4*raiz(6)), raiz(math.pi)/(12 + 4*raiz(6))]

    sum = 0

    for k in range(4):
        sum += f(x[k]) * w[k]
    
    return sum

#-=-=-=-=-=-=-=Laguerre=-=-=-=-=-=-=-

def intLaguerre2Pontos(f):
    x = [2 - raiz(2), 2 + raiz(2)]
    w = [(1/4)*(2 + raiz(2)), (1/4)*(2 - raiz(2))]

    sum = 0

    for k in range(2):
        sum += f(x[k]) * w[k]
    
    return sum

def intLaguerre3Pontos(f):
    x = [0.4157745568, 2.2942803603, 6.2899450829]
    w = [0.7110930099, 0.2785177336, 0.0103892565]

    sum = 0

    for k in range(3):
        sum += f(x[k]) * w[k]
    
    return sum

def intLaguerre4Pontos(f):
    x = [0.32255, 1.7458, 4.5366, 9.3951]
    w = [0.603115, 0.357347, 0.0388895, 0.00053928]

    sum = 0

    for k in range(4):
        sum += f(x[k]) * w[k]
    
    return sum

#-=-=-=-=-=-=-=Chebyshev=-=-=-=-=-=-=-

def intChebyshev2Pontos(f):
    x = [-1/raiz(2), 1/raiz(2)]
    w = [math.pi/2, math.pi/2]

    sum = 0

    for k in range(2):
        sum += f(x[k]) * w[k]
    
    return sum

def intChebyshev3Pontos(f):
    x = [-raiz(3)/2, 0, raiz(3)/2]
    w = [math.pi/3, math.pi/3, math.pi/3]

    sum = 0

    for k in range(3):
        sum += f(x[k]) * w[k]
    
    return sum

def intChebyshev4Pontos(f):
    x = [-(1/2)*raiz(2 + raiz(2)), -(1/2)*raiz(2 - raiz(2)), (1/2)*raiz(2 - raiz(2)), (1/2)*raiz(2 + raiz(2))]
    w = [math.pi/4, math.pi/4, math.pi/4, math.pi/4]

    sum = 0

    for k in range(4):
        sum += f(x[k]) * w[k]
    
    return sum

def integrar(f, pontos, tipo):
    if tipo == 0:
        if pontos == 2:
            return intHermite2Pontos(f)
        elif pontos == 3:
            return intHermite3Pontos(f)
        elif pontos == 4:
            return intHermite4Pontos(f)
    elif tipo == 1:
        if pontos == 2:
            return intLaguerre2Pontos(f)
        elif pontos == 3:
            return intLaguerre3Pontos(f)
        elif pontos == 4:
            return intLaguerre4Pontos(f)
    elif tipo == 2:
        if pontos == 2:
            return intChebyshev2Pontos(f)
        elif pontos == 3:
            return intChebyshev3Pontos(f)
        elif pontos == 4:
            return intChebyshev4Pontos(f)
    else:
        print("----> ERRO: Grau ou modo inválidos! <----")