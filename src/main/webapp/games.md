classDiagram
direction BT
class balance_details {
   bigint operation_id
   varchar operation_type
   varchar type_det_operation
   date operation_date
   double precision operation_volume
   double precision result_balance
   integer user_id
}
class games {
   bigint game_id
   varchar game_type
   date game_date
   varchar game_winner
}
class user_games {
   bigint user_id
   bigint game_id
   double precision money_in
   double precision money_back
}
class users {
   varchar Login
   varchar password
   date registration_date
   integer Score
   varchar registration_type
   varchar e-mail
   double precision balance
   bigint id
}
class users_data {
   integer user_id
   varchar first_name
   varchar last_name
   date date_of_birth
   varchar nationality
}

balance_details  -->  users : user_id:id
user_games  -->  games : game_id
user_games  -->  users : user_id:id
users_data  -->  users : user_id:id
