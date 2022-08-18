select customers.customer_id, customers.company_name, orders.order_id from ((customers
inner join orders on customers.customer_id = orders.customer_id)
inner join shippers on orders.ship_name )
where contact_name  = 'Simons bistro' and  company_name = 'United Package';