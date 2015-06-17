
Insert into registered_users (id,user_name,full_name,email_address,password,password_profile,password_expiry_date) values (1,'mayur','Mayur Kavhalkar','test@testmail.com','mayur','mayur','11/06/2030');
Insert into registered_users (id,user_name,full_name,email_address,password,password_profile,password_expiry_date) values (2,'prassan','Prassan Sherekar','test1@testmail.com','prasaan','prassan','12/06/2030');


Insert into event_history (id ,event_type,event_time,url,useragent,ip_address,user_id) values (1,'Login','11/06/2015','www.test.com','mayur','225.225.1.1',1);
Insert into event_history (id ,event_type,event_time,url,useragent,ip_address,user_id) values (2,'Login','11/06/2015','www.test.com','prassan','225.225.1.2',2);

Insert into stock_tweets (id,tweet_id,stock_id,stock_name,user_name,tweet_time,user_id)values (1,1,1,'Bank Nifty','mayur','now()',1);
Insert into stock_tweets (id,tweet_id,stock_id,stock_name,user_name,tweet_time,user_id)values (2,2,1,'Bank Nifty','prassan','now()',2);

Insert into stock_sentiment (id,stock_id,stock_name,user_id,tweet_id,sentiment,sentiment_time) values (1,1,'Bank Nifty',1,1,'NEUTRAL','now()');

Insert into user_actions (id,source_user_id,target_user_id,target_stock_id,action_type,action_time) values (1,1,2,1,'mayur','now()');
Insert into user_actions (id,source_user_id,target_user_id,target_stock_id,action_type,action_time) values (2,2,1,1,'prasaan','now()');

Insert into user_tweets (id,tweet,tweet_type,stock_name,user_name,tweet_time,user_id) values (1,decode('013d7d16d7ad4fefb61bd95b765c8ceb', 'hex'),'tweettype','Bank Nifty','mayur','now()',1);
Insert into user_tweets (id,tweet,tweet_type,stock_name,user_name,tweet_time,user_id) values (2,decode('013d7d16d7ad4fefb61bd95b765c8ceb', 'hex'),'tweettype','Bank Nifty','prassan','now()',2);

ALTER TABLE stock_tweets ALTER COLUMN stock_name TYPE character varying(200);
	
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (2, 2, 'CNX Infrastructure Index','CNXINFRA','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (3, 3, 'CNX IT Index','CNXIT','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (5, 5, 'Nifty Mid Cap Index','NFTYMCAP50','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (6, 6, 'NIFTY','NIFTY','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (7, 7, 'India VIX Index','INDIAVIX','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (8, 8, 'Aditya Birla NUVO	','ABIRLANUVO','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (9, 9, 'Associate Cement Company','ACC','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (10, 10, 'Adani Enterprises','ADANIENT','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (11, 11, 'Adani Ports','ADANIPORTS','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (12, 12, 'Adani Power','ADANIPOWER','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (13, 13, 'Allahabad Bank','	ALBK','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (14, 14, 'Ambuja Cement','AMBUJACEM','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (15, 15, 'Amtek Auto','AMTEKAUTO','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (16, 16, 'Andhra Bank','ANDHRABANK','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (17, 17, 'Apollo Hospitals','APOLLOHOSP','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (18, 18, 'Apollo Tyres','APOLLOTYRE','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (19, 19, 'Arvind Mills','ARVIND','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (20, 20, 'Ashok Leyland','ASHOKLEY','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (21, 21, 'Asian Paints','ASIANPAINT','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (22, 22, 'Aurobindo Pharma','AUROPHARMA','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (23, 23, 'Axis Bank','AXISBANK','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (24, 24, 'Bajaj Auto','BAJAJ-AUTO','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (25, 25, 'Bank of Baroda','BANKBARODA','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (26, 26, 'Bank of India','BANKINDIA','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (27, 27, 'Bata','BATAINDIA','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (28, 28, 'Bharat Forge','BHARATFORG','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (29, 29, 'Bharti Airtel','BHARTIARTL','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (30, 30, 'BHEL','BHEL','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (31, 31, 'BIOCON','BIOCON','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (32, 32, 'Bosch','BOSCHLTD','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (33, 33, 'BPCL','BPCL','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (34, 34, 'Cairn India','CAIRN','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (35, 35, 'Canara Bank','CANBK','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (36, 36, 'Century Textile','CENTURYTEX','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (37, 37, 'CESC','CESC','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (38, 38, 'CIPLA','CIPLA','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (39, 39, 'COAL India','COALINDIA','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (40, 40, 'Colgate Palmolive','COLPAL','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (41, 41, 'Crompton Greaves','CROMPGREAV','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (42, 42, 'Dabur','DABUR','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (43, 43, 'Dish TV','DISHTV','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (44, 44, 'DIVIS Lab','DIVISLAB','now()','now()','SYSTEM');  
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (2, 2, 'CNX Infrastructure Index','CNXINFRA','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (3, 3, 'CNX IT Index','CNXIT','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (4, 4, 'CNX Public Sector Enterprise Index','CNXPSE','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (5, 5, 'Nifty Mid Cap Index','NFTYMCAP50','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (6, 6, 'NIFTY	NIFTY','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (7, 7, 'India VIX Index','INDIAVIX','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (8, 8, 'Aditya Birla NUVO	','ABIRLANUVO','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (9, 9, 'Associate Cement Company','ACC','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (10, 10, 'Adani Enterprises','ADANIENT','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (11, 11, 'Adani Ports','ADANIPORTS','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (12, 12, 'Adani Power','ADANIPOWER','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (13, 13, 'Allahabad Bank','	ALBK','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (14, 14, 'Ambuja Cement','AMBUJACEM','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (15, 15, 'Amtek Auto','AMTEKAUTO','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (16, 16, 'Andhra Bank','ANDHRABANK','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (17, 17, 'Apollo Hospitals','APOLLOHOSP','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (18, 18, 'Apollo Tyres','APOLLOTYRE','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (19, 19, 'Arvind Mills','ARVIND','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (20, 20, 'Ashok Leyland','ASHOKLEY','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (21, 21, 'Asian Paints','ASIANPAINT','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (22, 22, 'Aurobindo Pharma','AUROPHARMA','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (23, 23, 'Axis Bank','AXISBANK','now()','now()','SYSTEM');

Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (24, 24, 'Bajaj Auto','BAJAJ-AUTO','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (25, 25, 'Bank of Baroda','BANKBARODA','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (26, 26, 'Bank of India','BANKINDIA','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (27, 27, 'Bata','BATAINDIA','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (28, 28, 'Bharat Forge','BHARATFORG','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (29, 29, 'Bharti Airtel','BHARTIARTL','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (30, 30, 'BHEL','BHEL','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (31, 31, 'BIOCON','BIOCON','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (32, 32, 'Bosch','BOSCHLTD','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (33, 33, 'BPCL','BPCL','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (34, 34, 'Cairn India','CAIRN','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (35, 35, 'Canara Bank','CANBK','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (36, 36, 'Century Textile','CENTURYTEX','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (37, 37, 'CESC','CESC','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (38, 38, 'CIPLA','CIPLA','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (39, 39, 'COAL India','COALINDIA','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (40, 40, 'Colgate Palmolive','COLPAL','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (41, 41, 'Crompton Greaves','CROMPGREAV','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (42, 42, 'Dabur','DABUR','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (43, 43, 'Dish TV','DISHTV','now()','now()','SYSTEM');
Insert into stock_info (id,stock_id,stock_name,stock_short_name,create_time,update_time,source_info) values (44, 44, 'DIVIS Lab','DIVISLAB','now()','now()','SYSTEM');