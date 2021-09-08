import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv('./dados.csv', index_col=0)

df.plot(subplots=True, layout=(2, 1), sharex=False)
plt.show()