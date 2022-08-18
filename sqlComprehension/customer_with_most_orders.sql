select contact_name, max (quantity) from ((customers inner join orders 
on customers.customer_id = orders.customer_id )
inner join order_details on orders.order_id = order_details.order_id);