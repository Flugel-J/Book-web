USE [master]
GO
/****** Object:  Database [bookwebproj]    Script Date: 4/9/2022 4:35:26 PM ******/
CREATE DATABASE [bookwebproj]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'bookwebproj', FILENAME = N'C:\SQL\bookwebproj.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'bookwebproj_log', FILENAME = N'C:\SQL\bookwebproj_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [bookwebproj] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [bookwebproj].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [bookwebproj] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [bookwebproj] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [bookwebproj] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [bookwebproj] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [bookwebproj] SET ARITHABORT OFF 
GO
ALTER DATABASE [bookwebproj] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [bookwebproj] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [bookwebproj] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [bookwebproj] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [bookwebproj] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [bookwebproj] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [bookwebproj] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [bookwebproj] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [bookwebproj] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [bookwebproj] SET  DISABLE_BROKER 
GO
ALTER DATABASE [bookwebproj] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [bookwebproj] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [bookwebproj] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [bookwebproj] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [bookwebproj] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [bookwebproj] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [bookwebproj] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [bookwebproj] SET RECOVERY FULL 
GO
ALTER DATABASE [bookwebproj] SET  MULTI_USER 
GO
ALTER DATABASE [bookwebproj] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [bookwebproj] SET DB_CHAINING OFF 
GO
ALTER DATABASE [bookwebproj] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [bookwebproj] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [bookwebproj] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [bookwebproj] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'bookwebproj', N'ON'
GO
ALTER DATABASE [bookwebproj] SET QUERY_STORE = OFF
GO
USE [bookwebproj]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 4/9/2022 4:35:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[RecordID] [int] NOT NULL,
	[Category] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[RecordID] ASC,
	[Category] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Comment]    Script Date: 4/9/2022 4:35:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comment](
	[CommentID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](30) NOT NULL,
	[RecordID] [int] NOT NULL,
	[TimeComment] [date] NULL,
	[Detail] [nvarchar](max) NOT NULL,
	[Like] [int] NOT NULL,
 CONSTRAINT [PK_Comment] PRIMARY KEY CLUSTERED 
(
	[CommentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Read]    Script Date: 4/9/2022 4:35:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Read](
	[Username] [nvarchar](30) NOT NULL,
	[RecordID] [int] NOT NULL,
	[TimeRead] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC,
	[RecordID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Record]    Script Date: 4/9/2022 4:35:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Record](
	[RecordID] [int] IDENTITY(1,1) NOT NULL,
	[Uploader] [nvarchar](30) NULL,
	[Title] [nvarchar](50) NULL,
	[TimeCreate] [datetime] NULL,
	[Description] [nvarchar](260) NULL,
	[Viewed] [int] NULL,
	[Detail] [varchar](200) NOT NULL,
	[image] [varchar](255) NULL,
	[status] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[RecordID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ReportComment]    Script Date: 4/9/2022 4:35:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReportComment](
	[CommentID] [int] NULL,
	[Username] [nvarchar](30) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ReportRecord]    Script Date: 4/9/2022 4:35:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReportRecord](
	[RecordID] [int] NULL,
	[Username] [nvarchar](30) NULL,
	[Report] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserInfo]    Script Date: 4/9/2022 4:35:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserInfo](
	[Username] [nvarchar](30) NOT NULL,
	[Name] [nvarchar](30) NULL,
	[Birthday] [date] NULL,
	[Email] [nvarchar](30) NULL,
	[Gender] [char](1) NULL,
	[Intro] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 4/9/2022 4:35:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[Username] [nvarchar](30) NOT NULL,
	[Password] [varchar](30) NOT NULL,
	[Status] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (1, N'horror')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (1, N'myth')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (1, N'sci-fi')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (2, N'fiction')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (2, N'game')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (2, N'novel')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (2, N'supernature')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (9, N'drama')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (9, N'mystery')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (9, N'psychological')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (10, N'math')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (10, N'statistic')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (10, N'variable')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (28, N'romance')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (28, N'school life')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (37, N'fiction')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (37, N'novel')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (38, N'game')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (38, N'supernature')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (39, N'drama')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (39, N'mystery')
INSERT [dbo].[Categories] ([RecordID], [Category]) VALUES (39, N'psychological')
GO
SET IDENTITY_INSERT [dbo].[Comment] ON 

INSERT [dbo].[Comment] ([CommentID], [Username], [RecordID], [TimeComment], [Detail], [Like]) VALUES (1, N'hoangvu', 1, CAST(N'2022-03-13' AS Date), N'ok', 4)
INSERT [dbo].[Comment] ([CommentID], [Username], [RecordID], [TimeComment], [Detail], [Like]) VALUES (3, N'hoang', 37, CAST(N'2022-03-13' AS Date), N'wtffff', 4)
INSERT [dbo].[Comment] ([CommentID], [Username], [RecordID], [TimeComment], [Detail], [Like]) VALUES (4, N'hoang', 22, CAST(N'2022-03-13' AS Date), N'my head
', 0)
INSERT [dbo].[Comment] ([CommentID], [Username], [RecordID], [TimeComment], [Detail], [Like]) VALUES (6, N'hoang', 37, CAST(N'2022-03-17' AS Date), N'd', 0)
SET IDENTITY_INSERT [dbo].[Comment] OFF
GO
INSERT [dbo].[Read] ([Username], [RecordID], [TimeRead]) VALUES (N'hoang', 2, CAST(N'2022-03-11' AS Date))
INSERT [dbo].[Read] ([Username], [RecordID], [TimeRead]) VALUES (N'hoang', 9, CAST(N'2022-03-10' AS Date))
INSERT [dbo].[Read] ([Username], [RecordID], [TimeRead]) VALUES (N'hoang', 37, CAST(N'2022-03-15' AS Date))
GO
SET IDENTITY_INSERT [dbo].[Record] ON 

INSERT [dbo].[Record] ([RecordID], [Uploader], [Title], [TimeCreate], [Description], [Viewed], [Detail], [image], [status]) VALUES (1, N'hoangvu', N'The Call of Cthulhu', CAST(N'1900-01-01T00:00:00.000' AS DateTime), N'a myth about octopus', 3, N'thecallofCthulhu.pdf', NULL, 1)
INSERT [dbo].[Record] ([RecordID], [Uploader], [Title], [TimeCreate], [Description], [Viewed], [Detail], [image], [status]) VALUES (2, N'hoangvu', N'No game no life', CAST(N'2022-02-06T12:14:42.607' AS DateTime), N'sibling play game', 8, N'No Game No Life, Vol. 9.pdf', NULL, 1)
INSERT [dbo].[Record] ([RecordID], [Uploader], [Title], [TimeCreate], [Description], [Viewed], [Detail], [image], [status]) VALUES (9, N'hoang', N'tactless tactic', CAST(N'2022-02-24T13:19:30.437' AS DateTime), N'tactless tactic', 3, N'tactless tactic9.pdf', NULL, 1)
INSERT [dbo].[Record] ([RecordID], [Uploader], [Title], [TimeCreate], [Description], [Viewed], [Detail], [image], [status]) VALUES (10, N'hoang', N'Discreate random variable', CAST(N'2022-03-09T15:27:10.497' AS DateTime), N'Discreate random variable', 2, N'Discreate random variable10.pdf', NULL, 1)
INSERT [dbo].[Record] ([RecordID], [Uploader], [Title], [TimeCreate], [Description], [Viewed], [Detail], [image], [status]) VALUES (22, N'hoang', N'Void', CAST(N'2022-03-12T12:24:38.050' AS DateTime), N'@MyHeadHurts - Fair enough, though for my money they''re both still basically the same. Content scrolls underneath the fixed footer, when there is enough content to do so. That''s good enough for me. Of course, I can see how very large footers like what the', 4, N'Void11.pdf', NULL, 1)
INSERT [dbo].[Record] ([RecordID], [Uploader], [Title], [TimeCreate], [Description], [Viewed], [Detail], [image], [status]) VALUES (28, N'hoang', N'Shomin sample', CAST(N'2022-03-11T21:02:40.437' AS DateTime), N'turns True if all elements in the collection col are present in the List otherwise it returns False.  Exception: The method throws NullPointerException if the specified collection is NULL.  Below programs illustrates the containsAll() method:', 3, N'Shomin sample23.pdf', NULL, 1)
INSERT [dbo].[Record] ([RecordID], [Uploader], [Title], [TimeCreate], [Description], [Viewed], [Detail], [image], [status]) VALUES (30, N'hoang', N'sample', CAST(N'2022-03-12T19:07:50.167' AS DateTime), N'sample', 3, N'2022-03-12_19:07:50sample.pdf', NULL, 0)
INSERT [dbo].[Record] ([RecordID], [Uploader], [Title], [TimeCreate], [Description], [Viewed], [Detail], [image], [status]) VALUES (34, N'hoang', N'sample with image', CAST(N'2022-03-12T19:26:53.667' AS DateTime), N'image', 0, N'20220312_192653sample with image.pdf', N'20220312_19265320.jpg', 1)
INSERT [dbo].[Record] ([RecordID], [Uploader], [Title], [TimeCreate], [Description], [Viewed], [Detail], [image], [status]) VALUES (37, N'hoang', N'ads', CAST(N'2022-03-17T12:57:36.577' AS DateTime), N'ADS', 7, N'20220312_200718ads.pdf', NULL, 1)
INSERT [dbo].[Record] ([RecordID], [Uploader], [Title], [TimeCreate], [Description], [Viewed], [Detail], [image], [status]) VALUES (38, N'hoang', N'new sample with image', CAST(N'2022-03-13T15:26:25.567' AS DateTime), N'@MyHeadHurts - Fair enough, though for my money they''re both still basically the same. Content scrolls underneath the fixed footer, when there is enough content to do so. That''s good enough for me. Of course, I can see how very large footers like what the', 1, N'20220313_142448new sample with image.pdf', N'20220313_15262520220313_1526253.jpg', 1)
INSERT [dbo].[Record] ([RecordID], [Uploader], [Title], [TimeCreate], [Description], [Viewed], [Detail], [image], [status]) VALUES (39, N'hoang', N'sample ', CAST(N'2022-03-17T13:51:02.890' AS DateTime), N'sample', 0, N'20220317_135102sample .pdf', N'20220317_13510220220317_135102aa.jfif', 1)
SET IDENTITY_INSERT [dbo].[Record] OFF
GO
INSERT [dbo].[ReportRecord] ([RecordID], [Username], [Report]) VALUES (37, NULL, N'yoo like shit')
INSERT [dbo].[ReportRecord] ([RecordID], [Username], [Report]) VALUES (37, N'hoangvu', N'bruh so dumb')
INSERT [dbo].[ReportRecord] ([RecordID], [Username], [Report]) VALUES (37, NULL, N'this book is a scam')
INSERT [dbo].[ReportRecord] ([RecordID], [Username], [Report]) VALUES (37, NULL, N'sick duck')
GO
INSERT [dbo].[UserInfo] ([Username], [Name], [Birthday], [Email], [Gender], [Intro]) VALUES (N'h', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[UserInfo] ([Username], [Name], [Birthday], [Email], [Gender], [Intro]) VALUES (N'hi', NULL, CAST(N'2002-03-11' AS Date), N'ho@gmail.com', N'1', NULL)
INSERT [dbo].[UserInfo] ([Username], [Name], [Birthday], [Email], [Gender], [Intro]) VALUES (N'hoang', N'hoang', CAST(N'2002-02-23' AS Date), N'hoang20021103@gmail.com', N'0', N'skrrr')
INSERT [dbo].[UserInfo] ([Username], [Name], [Birthday], [Email], [Gender], [Intro]) VALUES (N'hoangvu', N'h', CAST(N'2002-03-11' AS Date), NULL, N'1', NULL)
INSERT [dbo].[UserInfo] ([Username], [Name], [Birthday], [Email], [Gender], [Intro]) VALUES (N's', NULL, NULL, N'damn@gmail.com', N'0', NULL)
GO
INSERT [dbo].[Users] ([Username], [Password], [Status]) VALUES (N'h', N'123', N'1')
INSERT [dbo].[Users] ([Username], [Password], [Status]) VALUES (N'hhh', N'123', N'1')
INSERT [dbo].[Users] ([Username], [Password], [Status]) VALUES (N'hi', N'123', N'1')
INSERT [dbo].[Users] ([Username], [Password], [Status]) VALUES (N'hoang', N'123', N'1')
INSERT [dbo].[Users] ([Username], [Password], [Status]) VALUES (N'hoang1', N'111', N'1')
INSERT [dbo].[Users] ([Username], [Password], [Status]) VALUES (N'hoangvu', N'123', N'0')
INSERT [dbo].[Users] ([Username], [Password], [Status]) VALUES (N's', N'111', N'1')
GO
ALTER TABLE [dbo].[Comment] ADD  DEFAULT (getdate()) FOR [TimeComment]
GO
ALTER TABLE [dbo].[Comment] ADD  DEFAULT ((0)) FOR [Like]
GO
ALTER TABLE [dbo].[Read] ADD  DEFAULT (getdate()) FOR [TimeRead]
GO
ALTER TABLE [dbo].[Record] ADD  DEFAULT (getdate()) FOR [TimeCreate]
GO
ALTER TABLE [dbo].[Record] ADD  CONSTRAINT [DF_Record_status]  DEFAULT ((1)) FOR [status]
GO
ALTER TABLE [dbo].[Categories]  WITH CHECK ADD FOREIGN KEY([RecordID])
REFERENCES [dbo].[Record] ([RecordID])
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD FOREIGN KEY([RecordID])
REFERENCES [dbo].[Record] ([RecordID])
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD FOREIGN KEY([Username])
REFERENCES [dbo].[Users] ([Username])
GO
ALTER TABLE [dbo].[Read]  WITH CHECK ADD FOREIGN KEY([RecordID])
REFERENCES [dbo].[Record] ([RecordID])
GO
ALTER TABLE [dbo].[Read]  WITH CHECK ADD FOREIGN KEY([Username])
REFERENCES [dbo].[UserInfo] ([Username])
GO
ALTER TABLE [dbo].[Record]  WITH CHECK ADD FOREIGN KEY([Uploader])
REFERENCES [dbo].[Users] ([Username])
GO
ALTER TABLE [dbo].[ReportComment]  WITH CHECK ADD FOREIGN KEY([CommentID])
REFERENCES [dbo].[Comment] ([CommentID])
GO
ALTER TABLE [dbo].[ReportRecord]  WITH CHECK ADD FOREIGN KEY([RecordID])
REFERENCES [dbo].[Record] ([RecordID])
GO
ALTER TABLE [dbo].[UserInfo]  WITH CHECK ADD FOREIGN KEY([Username])
REFERENCES [dbo].[Users] ([Username])
GO
USE [master]
GO
ALTER DATABASE [bookwebproj] SET  READ_WRITE 
GO
