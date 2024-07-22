def busqueda_binaria(array, valor_buscado):
    inicio = 0
    fin = len(array) - 1

    while inicio <= fin:
        medio = (inicio + fin) // 2
        if array[medio] == valor_buscado:
            return medio
        elif array[medio] < valor_buscado:
            inicio = medio + 1
        else:
            fin = medio - 1

    return -1  # Valor no encontrado
