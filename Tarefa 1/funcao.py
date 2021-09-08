import math

def f(x):
    return math.log(2*x) * math.cos(4*x)

x = 4.3
dx = 0.001

df2n = (1.0 / dx**2) * (-(49.0 / 18.0) * f(x) + (3.0 / 2.0) * f(x + dx)
				+ (3.0 / 2.0) * f(x - dx) - (3.0 / 20.0) * f(x + 2 * dx) - (3.0 / 20.0) * f(x - 2 * dx)
				+ (1.0 / 90.0) * f(x + 3 * dx) + (1.0 / 90.0) * f(x - 3 * dx))

print(df2n)