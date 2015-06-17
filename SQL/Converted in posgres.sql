CREATE TABLE registered_users
(
   ID                     INTEGER NOT NULL,
   USER_NAME              VARCHAR (30) NOT NULL,
  FULL_NAME              VARCHAR (255) NOT NULL,
  EMAIL_ADDRESS              VARCHAR (100) NOT NULL,
   PASSWORD               VARCHAR (30) NOT NULL,
   LAST_LOGIN_TIME        TIMESTAMP (6),
   PASSWORD_PROFILE       VARCHAR (10) NOT NULL,
   PASSWORD_EXPIRY_DATE   TIMESTAMP (6) NOT NULL,
   CONSTRAINT reg_users_pk PRIMARY KEY (ID),
   CONSTRAINT reg_users_user_name_uk UNIQUE (USER_NAME),
CONSTRAINT reg_users_email_address_uk UNIQUE (EMAIL_ADDRESS));

COMMENT ON TABLE registered_users IS
   'Table holds the information of all users.';
COMMENT ON COLUMN registered_users.id IS 'Primary Key of the table.';
COMMENT ON COLUMN registered_users.user_name IS
   'User name of the trading social account. It is a unique identifier.';
COMMENT ON COLUMN registered_users.password IS
   'Encrypted form of the password.';
COMMENT ON COLUMN registered_users.last_login_time IS
   'Timestamp of login with a precision of microseconds.';
COMMENT ON COLUMN registered_users.password_profile IS
   'Depending on the values here, a user''s password expiry is controlled. Eg. A value of ''FOREVER'' means a user''s password cannot expire.';
COMMENT ON COLUMN registered_users.password_expiry_date IS
   'Date of expiry of the password.';

-- USER_NAME needs a unique key, ID needs to be a PK.

CREATE SEQUENCE registered_users_seq;

CREATE TABLE event_history
(
   ID           INTEGER NOT NULL,
   EVENT_TYPE   VARCHAR (50) NOT NULL,
   EVENT_TIME   TIMESTAMP (6) with time zone DEFAULT now(),
   URL          VARCHAR (500) NOT NULL,
   USERAGENT    VARCHAR (500) NOT NULL,
   IP_ADDRESS   VARCHAR (50) NOT NULL,
   USER_ID      INTEGER NOT NULL,
   CONSTRAINT event_history_pk PRIMARY KEY (ID),
   CONSTRAINT evt_hist_user_id_fk FOREIGN KEY
      (user_id)
       REFERENCES registered_users (ID)
);

COMMENT ON TABLE event_history IS
   'Table holds the history of event information of all users.';
COMMENT ON COLUMN event_history.id IS 'Primary Key of the table.';
COMMENT ON COLUMN event_history.event_time IS 'Timestamp of event.';
COMMENT ON COLUMN event_history.url IS '';
COMMENT ON COLUMN event_history.useragent IS
   'Captures the useragent from which end user login is attempted.';
COMMENT ON COLUMN event_history.user_id IS
'User identifier. Foreign Key to registered_users.id.';

CREATE SEQUENCE event_history_seq;

CREATE TABLE user_tweets
(
   ID           INTEGER NOT NULL,
   TWEET        BYTEA NOT NULL,
   TWEET_TYPE   VARCHAR (30) NOT NULL,
   STOCK_NAME   VARCHAR (30) NOT NULL,
   USER_NAME    VARCHAR (30) NOT NULL,
   TWEET_TIME   TIMESTAMP (6) with time zone DEFAULT now(),
   USER_ID      INTEGER NOT NULL,
   CONSTRAINT user_tweets_pk PRIMARY KEY (ID),
   CONSTRAINT user_tweets_user_uk UNIQUE (USER_ID, USER_NAME),
   CONSTRAINT user_tweets_user_id_fk FOREIGN KEY
      (user_id)
       REFERENCES registered_users (ID)
);

COMMENT ON TABLE user_tweets IS
   'Table to hold all the tweets of a user.';
COMMENT ON COLUMN user_tweets.id IS 'Primary Key of the table.';
COMMENT ON COLUMN user_tweets.tweet IS
   'The content tweeted by the user.';
COMMENT ON COLUMN user_tweets.tweet_type IS
   'The type of tweet of the user.';
COMMENT ON COLUMN user_tweets.stock_name IS
   'The name of the stock tweeted by the user.';
COMMENT ON COLUMN user_tweets.user_name IS
   'User name of the tweeter. Same as registered_users.user_name.';
COMMENT ON COLUMN user_tweets.tweet_time IS 'Timestamp of the tweet.';
COMMENT ON COLUMN user_tweets.user_id IS
'User identifier. Foreign Key to registered_users.id.';

CREATE SEQUENCE user_tweets_seq;

-- unique key on user_id and user_name

CREATE TABLE stock_info
(
   ID                 INTEGER NOT NULL,
   STOCK_ID           INTEGER NOT NULL,
   STOCK_NAME         VARCHAR (30) NOT NULL,
   STOCK_SHORT_NAME   VARCHAR (15) NOT NULL,
   CREATE_TIME        TIMESTAMP (6) with time zone DEFAULT now(),
   UPDATE_TIME        TIMESTAMP (6),
   SOURCE_INFO        VARCHAR (10) NOT NULL,
   CONSTRAINT stock_info_pk PRIMARY KEY (ID),
   CONSTRAINT stock_info_uk UNIQUE (stock_id, stock_name, stock_short_name),
   CONSTRAINT stock_info_ck CHECK (source_info IN ('USER', 'SYSTEM'))
);

COMMENT ON TABLE stock_info IS
   'Table to hold information about the publicly traded stocks in the market.';
COMMENT ON COLUMN stock_info.id IS 'Primary Key of the table.';
COMMENT ON COLUMN stock_info.stock_id IS
   'The identifier of the stock.';
COMMENT ON COLUMN stock_info.stock_name IS
   'The name of the stock in the market.';
COMMENT ON COLUMN stock_info.stock_short_name IS
   'The short name of the stock in the market.';
COMMENT ON COLUMN stock_info.create_time IS
   'The timestamp of creation of a new stock entry.';
COMMENT ON COLUMN stock_info.update_time IS
   'The timestamp of the updation of a stock entry.';
COMMENT ON COLUMN stock_info.source_info IS
   'The source of the stock data, i.e, whether USER or SYSTEM generated.';

CREATE SEQUENCE stock_info_seq;

-- unique constraint on stock_id, stock_name, stock_short_name
-- check constraint on source_info.

CREATE TABLE stock_tweets
(
   ID           INTEGER,
   TWEET_ID     INTEGER NOT NULL,
   STOCK_ID     INTEGER NOT NULL,
   STOCK_NAME   VARCHAR (30) NOT NULL,
   USER_NAME    VARCHAR (30) NOT NULL,
   TWEET_TIME   TIMESTAMP (6) with time zone DEFAULT now(),
   USER_ID      INTEGER NOT NULL,
   CONSTRAINT stock_tweets_pk PRIMARY KEY (ID),
   CONSTRAINT stock_tweets_stock_id_fk FOREIGN KEY
      (stock_id)
       REFERENCES stock_info (ID),
   CONSTRAINT stock_tweets_user_id_fk FOREIGN KEY
      (user_id)
       REFERENCES registered_users (ID)
);

COMMENT ON TABLE stock_tweets IS
   'Table to hold all the tweets of a stock.';
COMMENT ON COLUMN stock_tweets.id IS 'Primary Key of the table.';
COMMENT ON COLUMN stock_tweets.tweet_id IS
   'The identifier of the stock tweet.';
COMMENT ON COLUMN stock_tweets.stock_id IS
'The identifier of the stock. Foreign key to stock_info.id.';
COMMENT ON COLUMN stock_tweets.stock_name IS 'The name of the stock.';
COMMENT ON COLUMN stock_tweets.user_name IS
   'User name of the tweeter.';
COMMENT ON COLUMN stock_tweets.tweet_time IS
   'Timestamp of the tweet.';
COMMENT ON COLUMN stock_tweets.user_id IS
'User identifier. Foreign Key to registered_users.id.';


CREATE TABLE stock_sentiment
(
   ID               INTEGER NOT NULL,
   STOCK_ID         INTEGER NOT NULL,
   STOCK_NAME       VARCHAR (30) NOT NULL,
   USER_ID          INTEGER NOT NULL,
   TWEET_ID         INTEGER NOT NULL,
   SENTIMENT        VARCHAR (30) NOT NULL,
   SENTIMENT_TIME   TIMESTAMP (6) with time zone DEFAULT now(),
   CONSTRAINT stock_sentiment_pk PRIMARY KEY (ID),
   CONSTRAINT stock_sentiment_stock_uk UNIQUE (stock_id, stock_name),
   CONSTRAINT stock_sentiment_stock_id_fk FOREIGN KEY
      (stock_id)
       REFERENCES stock_info (id),
   CONSTRAINT stock_sentiment_ck CHECK
      (sentiment IN ('BEARISH', 'BULLISH', 'NEUTRAL'))
);

COMMENT ON TABLE stock_sentiment IS
   'Table to hold the sentiments of a stock mapped to a user.';
COMMENT ON COLUMN stock_sentiment.id IS 'Primary Key of the table.';
COMMENT ON COLUMN stock_sentiment.stock_id IS
   'The identifier of the stock.';
COMMENT ON COLUMN stock_sentiment.stock_name IS
   'The name of the stock on which the user expresses his sentiments.';
COMMENT ON COLUMN stock_sentiment.user_id IS 'User identifier.';
COMMENT ON COLUMN stock_sentiment.tweet_id IS 'Tweet identifier.';
COMMENT ON COLUMN stock_sentiment.sentiment IS
   'Sentiment of the stock, i.e, whether BEARISH, BULLISH or NEUTRAL.';
COMMENT ON COLUMN stock_sentiment.sentiment_time IS
   'Timestamp of the sentiment.';

CREATE SEQUENCE stock_sentiment_seq;

-- check constraint on sentiment.
-- unique key on?
CREATE TABLE user_actions
(
   ID           	INTEGER NOT NULL,
   SOURCE_USER_ID	INTEGER NOT NULL,
   TARGET_USER_ID	INTEGER NOT NULL,
   TARGET_STOCK_ID	INTEGER NOT NULL,
   ACTION_TYPE  	VARCHAR(20) NOT NULL,
   ACTION_CONTENT 	BYTEA,
   ACTION_TIME		TIMESTAMP(6),
   CONSTRAINT user_actions_pk PRIMARY KEY (ID),
   CONSTRAINT user_actions_src_user_id_fk FOREIGN KEY
      (source_user_id)
       REFERENCES registered_users (ID),
   CONSTRAINT user_actions_tgt_user_id_fk FOREIGN KEY
      (target_user_id)
       REFERENCES registered_users (ID),
    CONSTRAINT user_actions_targ_stock_fk FOREIGN KEY
      (TARGET_STOCK_ID)
       REFERENCES stock_info (ID)	
);




