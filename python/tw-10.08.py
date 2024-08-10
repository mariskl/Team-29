grass_df = pokemon_df[pokemon_df['Type 1'] == 'Grass']
water_df = pokemon_df[pokemon_df['Type 1'] == 'Water']

sns.regplot(
    data=grass_df, x='Attack', y="Defense",
    ci=99, marker="x", color=".3", line_kws=dict(color="b"),
)

sns.regplot(
    data=water_df, x='Attack', y="Defense",
    ci=99, marker="o", color=".3", line_kws=dict(color="r"),
)

correlation3 = grass_df['Attack'].corr(grass_df['Defense'])
print('Pearson correlation coefficient for grass type:', correlation3)

correlation4 = water_df['Attack'].corr(water_df['Defense'])
print('Pearson correlation coefficient for water type:', correlation4)
