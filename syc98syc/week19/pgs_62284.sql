SELECT distinct cart_id
from cart_products
where name = "milk"
and cart_id in (
    select cart_id
    from cart_products
    where name = "yogurt"
);