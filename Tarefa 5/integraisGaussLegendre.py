import math

def int2Pontos(f, xi, xf):
    x = lambda a: (xi + xf)/2 + a * (xf - xi) / 2

    a = [-(1/3)**(1/2), (1/3)**(1/2)]
    w = [1, 1]

    sum = 0

    for k in range(2):
        sum += f(x(a[k])) * w[k]
    
    return sum * (xf - xi) / 2

def int3Pontos(f, xi, xf):
    x = lambda a: (xi + xf)/2 + a * (xf - xi) / 2

    a = [-(3/5)**(1/2), 0, (3/5)**(1/2)]
    w = [5/9, 8/9, 5/9]

    sum = 0

    for k in range(3):
        sum += f(x(a[k])) * w[k]
    
    return sum * (xf - xi) / 2

def int4Pontos(f, xi, xf):
    x = lambda a: (xi + xf)/2 + a * (xf - xi) / 2

    a = [
        -math.sqrt(3 / 7 + (2 * math.sqrt(6/5)) / 7),
        -math.sqrt(3 / 7 - (2 * math.sqrt(6/5)) / 7),
        math.sqrt(3 / 7 - (2 * math.sqrt(6/5)) / 7),
        math.sqrt(3 / 7 + (2 * math.sqrt(6/5)) / 7)
    ]

    w = [
        0.347852,
        0.652147,
        0.652147,
        0.347852
    ]

    sum = 0

    for k in range(4):
        sum += f(x(a[k])) * w[k]
    
    return sum * (xf - xi) / 2

def integrar(f, xi, xf, pontos):
    if pontos == 2:
        return int2Pontos(f, xi, xf)
    elif pontos == 3:
        return int3Pontos(f, xi, xf)
    elif pontos == 4:
        return int4Pontos(f, xi, xf)
    else:
        print("----> ERRO: Grau ou modo inválidos! <----")