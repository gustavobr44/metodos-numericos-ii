def intFechada1(f, xi, xf):
    dx = xf - xi

    return (dx/2)*(f(xi) + f(xf))

def intFechada2(f, xi, xf):
    dx = xf - xi
    h = dx/2

    return (h/3)*(f(xi) + 4*f(xi + h) + f(xf))

def intFechada3(f, xi, xf):
    dx = xf - xi
    h = dx/3

    return (3*h/8)*(f(xi) + 3*f(xi + h) + 3*f(xi + 2*h) + f(xf))

def intFechada4(f, xi, xf):
    dx = xf - xi
    h = dx/4

    return (2*h/45)*(7*f(xi) + 32*f(xi + h) + 12*f(xi + 2*h) + 32*f(xi + 3*h) + 7*f(xf))

def intAberta1(f, xi, xf):
    dx = xf - xi
    h = dx/3

    return (dx/2)*(f(xi + h) + f(xi + 2*h))

def intAberta2(f, xi, xf):
    dx = xf - xi
    h = dx/4

    return (4*h/3)*(2*f(xi + h) - f(xi + 2*h) + 2*f(xi + 3*h))

def intAberta3(f, xi, xf):
    dx = xf - xi
    h = dx/5

    return (5*h/24)*(11*f(xi + h) + f(xi + 2*h) + f(xi + 3*h) + 11*f(xi + 4*h))

def intAberta4(f, xi, xf):
    dx = xf - xi
    h = dx/6

    return (3*h/10)*(11*f(xi + h) - 14*f(xi + 2*h) + 26*f(xi + 3*h) - 14*f(xi + 4*h) + 11*f(xi + 5*h))
    #return (3*h/10)*(11*f(xi + h) - 14*f(xi + 2*h) + 52*f(xi + 3*h) - 14*f(xi + 4*h) + 11*f(xi + 5*h)) #Fórmula errada!

def integrar(f, xi, xf, grau, modo):
    if modo == 0:
        if grau == 1:
            return intFechada1(f, xi, xf)
        elif grau == 2:
            return intFechada2(f, xi, xf)
        elif grau == 3:
            return intFechada3(f, xi, xf)
        elif grau == 4:
            return intFechada4(f, xi, xf)
    elif modo == 1:
        if grau == 1:
            return intAberta1(f, xi, xf)
        elif grau == 2:
            return intAberta2(f, xi, xf)
        elif grau == 3:
            return intAberta3(f, xi, xf)
        elif grau == 4:
            return intAberta4(f, xi, xf)
    else:
        print("----> ERRO: Grau ou modo inválidos! <----")