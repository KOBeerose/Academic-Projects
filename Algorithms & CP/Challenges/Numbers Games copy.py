from sympy import sqrt


taille_du_probleme = int(input())
nombre_des_requetes = int(input())

for requete in range(nombre_des_requetes):
    i , j = input().split()
    contenu_i = sqrt((taille_du_probleme-int(i))**2)
    contenu_j = sqrt((taille_du_probleme-int(j))**2)
    maxi = max(contenu_i,contenu_j)
    print( maxi + 1)