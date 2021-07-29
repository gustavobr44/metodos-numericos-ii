import math as m

def intGL3Dupla(f, xi, xf, yi, yf):
    x = lambda a: (xi + xf)/2 + a * (xf - xi) / 2
    y = lambda a: (yi + yf)/2 + a * (yf - yi) / 2

    a = [-(3/5)**(1/2), 0, (3/5)**(1/2)]
    w = [5/9, 8/9, 5/9]

    sum = 0

    for i in range(3):
        for j in range(3):
            sum += f(x(a[j]), y(a[i])) * w[j] * w[i]
    
    return sum * ((xf - xi) / 2) * ((yf - yi) / 2)

def intGL3Tripla(f, xi, xf, yi, yf, zi, zf):
    x = lambda a: (xi + xf)/2 + a * (xf - xi) / 2
    y = lambda a: (yi + yf)/2 + a * (yf - yi) / 2
    z = lambda a: (zi + zf)/2 + a * (zf - zi) / 2

    a = [-(3/5)**(1/2), 0, (3/5)**(1/2)]
    w = [5/9, 8/9, 5/9]

    sum = 0

    for i in range(3):
        for j in range(3):
            for k in range(3):
                sum += f(x(a[i]), y(a[j]), z(a[k])) * w[i] * w[j] * w[k]
    
    return sum * ((xf - xi) / 2) * ((yf - yi) / 2) * ((zf - zi) / 2)

def iterar(f, xi, xf, yi, yf, e):
    dI = m.inf
    i = 0
    I = 0

    while dI > e:
        i += 1
        Ip = 0
        dx = (xf - xi)/i
        dy = (yf - yi)/i

        for j in range(i):
            for k in range(i):
                Ip += intGL3Dupla(f, xi + j*dx, xi + (j + 1)*dx, yi + k*dx, yi + (k + 1)*dx)
        
        dI = abs((Ip - I)/Ip)
        I = Ip
    
    return I, i

# f = lambda x, y: (m.sqrt((20*x)**2 + (20*y)**2 + 1))
# result = intGL3Dupla(f, -1, 1, -1, 1) * 2500

# f = lambda x, y: (m.sqrt(256*(x**2)*(m.cos(y)**2 + (1 - (x**2)*m.cos(y)**2)*m.sin(y)**2) + 1))*x*m.sqrt(1 - (x**2)*m.cos(y)**2)
# result = intGL3Dupla(f, 0, 1, 0, m.pi*2) * 40**2

# f = lambda x, y: (0.2*(x**2 - y**2))
# result = intGL3Dupla(f, -40, 40, -20, 20)

# f = lambda x, y: 64000 * m.sqrt(1 - x**2 * m.cos(y)**2) * (x**5 * m.sin(y)**2 * m.cos(y)**2 - x**3 * m.sin(y)**2 + 4 * x**3 * m.cos(y)**2)
# result = intGL3Dupla(f, 0, 1, 0, 2*m.pi)

# f = lambda x, y: 64000 * m.sqrt(1 - x**2) * (x**2 * (y**2 + 4) - y**2)
# result = intGL3Dupla(f, -1, 1, -1, 1)

f = lambda x, y: ((x + 1)**3) * (5 * ((m.cos(m.pi * y))**2) - 1) * 4000 * m.pi
result = iterar(f, -1, 1, -1, 1, 10**-6)

print(result)