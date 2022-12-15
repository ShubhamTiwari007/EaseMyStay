# EaseMyStay
use these data for request body
// user data 1
// ***************************************************************************
{
  "userId": 101,
  "firstName":"Ankit",
  "lastName": "Bhatiya",
  "role": "CUSTOMER",
  "mobileNumber": "+918860082597",
  "address": {
      "city": "Patna",
      "state": "Bihar",
      "country": "India",
      "pincode": "800014"
  },
  "emailId": "ankit0bhatia@gmail.com",
  "createdAt": "2022-12-15",
  "dob": "2002-09-06",
  "gender": "M",
  "password":"test@123"
}
// user data 2c
// ***************************************************************************
{
  "userId": 201,
  "firstName":"Rahul",
  "lastName": "Pandey",
  "role": "OWNER",
  "mobileNumber": "+918860082597",
  "address": {
      "city": "Lucknow",
      "state": "Uttar Pardesh",
      "country": "India",
      "pincode": "768534"
  },
  "emailId": "rahulownerofroyalhotel@gmail.com",
  "createdAt": "2022-12-15",
  "dob": "1974-02-04",
  "gender": "M",
  "password":"test@123"
}
//login
// ***************************************************************************
{
  "emailId": "ankit0bhatia@gmail.com",
  "password": "test@123"
}
// hotel data
// ***************************************************************************
{
  "aminities": [
    "Swimming pool",
    "Clubhouse",
    "Parking",
    "Common area",
    "Security",
    "Electric car charging station",
    "Kids’ play areas",
    "Elevators",
    "Washers and dryers",
    "Balconie",
    "Wi-Fi",
    "Pet-friendly space"
  ],
  "contacts": {
    "email": "royalHotle@gmail.com",
    "phoneNumber": 8889977766
  },
  "hnumber": "E-102, vijay nagar",
  "id": 401,
  "name": "Royal hotel",
  "rooms": [
    {
      "noOfRooms": 5,
      "price": 999,
      "roomType": "normal"
    },
    {
      "noOfRooms": 10,
      "price": 1099,
      "roomType": "dulex"
    },
    {
      "noOfRooms": 5,
      "price": 1799,
      "roomType": " super dulex"
    }
  ]
}
// booking data
// ***************************************************************************
{
    "bookingId": 1001,
    "checkInDate": "24/12/2022",
    "checkInTime": "11:30 AM",
    "checkOutDate": "2/01/2023",
    "checkOutTime": "12:00 PM",
    "noOfDays": 10,
    "noOfRooms": 2,
    "numberOfGuests": 5,
    "roomType": "normal"
}
// chat
// ***************************************************************************
{
  "customerId": 4563,
  "hotelId": 401,
  "message": [
    {
      "content": "Hi, stay in hotel was good. I lost my debit card, can you please confirm that it is in the same room of your hotel or not ?",
      "datetime": "2022-12-14T06:46:54.348Z",
      "senderId": 101
    }
  ]
}
// feedback
// ***************************************************************************
{
  "id": 901,
  "message": "The room is decently sized. I still expected it to be cleaner and have hangers in the wardrobe. The bedsheets were a bit stinking of some weird 'spices' over-all good experience with the staff and food as the breakfast spread was quite good.",
  "title": "Third rate hotel",
  "stayType": "solo",
  "filters": ["test","happy","cool"],
  "ratings": {
      "hospitality": 4,
      "valueformoney": 4,
      "location": 4,
      "facilities": 4,
      "cleanliness": 4
  }
}
