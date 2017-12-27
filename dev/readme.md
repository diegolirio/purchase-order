

# Exportar DB pedido
```
mysqldump -uroot -p pedido > ~/bkp.pedido.db 
```
# Importar DB pedido
```
mysql -uroot -p 
use pedido
source ~/bkp.pedido.db
```

fonte: https://www.vivaolinux.com.br/dica/MySQL-Importar-e-exportar-todos-os-bancos-usando-mysqldump-e-source/ 
