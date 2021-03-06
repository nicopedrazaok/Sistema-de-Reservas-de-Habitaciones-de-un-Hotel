USE [master]
GO
/****** Object:  Database [DBReservaHotel]    Script Date: 21/12/2020 18:10:08 ******/
CREATE DATABASE [DBReservaHotel]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DBReservaHotel', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\DBReservaHotel.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DBReservaHotel_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\DBReservaHotel_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [DBReservaHotel] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DBReservaHotel].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DBReservaHotel] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DBReservaHotel] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DBReservaHotel] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DBReservaHotel] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DBReservaHotel] SET ARITHABORT OFF 
GO
ALTER DATABASE [DBReservaHotel] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [DBReservaHotel] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DBReservaHotel] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DBReservaHotel] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DBReservaHotel] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DBReservaHotel] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DBReservaHotel] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DBReservaHotel] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DBReservaHotel] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DBReservaHotel] SET  ENABLE_BROKER 
GO
ALTER DATABASE [DBReservaHotel] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DBReservaHotel] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DBReservaHotel] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DBReservaHotel] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DBReservaHotel] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DBReservaHotel] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DBReservaHotel] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DBReservaHotel] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DBReservaHotel] SET  MULTI_USER 
GO
ALTER DATABASE [DBReservaHotel] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DBReservaHotel] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DBReservaHotel] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DBReservaHotel] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DBReservaHotel] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DBReservaHotel] SET QUERY_STORE = OFF
GO
USE [DBReservaHotel]
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 21/12/2020 18:10:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[idPersona] [int] NOT NULL,
	[codigoCliente] [varchar](10) NOT NULL,
 CONSTRAINT [pk_cliente] PRIMARY KEY CLUSTERED 
(
	[idPersona] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Consumo]    Script Date: 21/12/2020 18:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Consumo](
	[idConsumo] [int] IDENTITY(1,1) NOT NULL,
	[idReserva] [int] NOT NULL,
	[idProducto] [int] NOT NULL,
	[cantidad] [decimal](7, 2) NULL,
	[precioVenta] [decimal](7, 2) NULL,
	[estado] [varchar](15) NULL,
 CONSTRAINT [pk_Consumo] PRIMARY KEY CLUSTERED 
(
	[idConsumo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Habitacion]    Script Date: 21/12/2020 18:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Habitacion](
	[idHabitacion] [int] IDENTITY(1,1) NOT NULL,
	[numero] [varchar](4) NOT NULL,
	[piso] [varchar](2) NOT NULL,
	[descripcion] [varchar](255) NULL,
	[carateristica] [varchar](512) NULL,
	[precioDiario] [decimal](7, 2) NOT NULL,
	[estado] [varchar](15) NOT NULL,
	[tipoHabitacion] [varchar](20) NOT NULL,
 CONSTRAINT [pk_habitacion] PRIMARY KEY CLUSTERED 
(
	[idHabitacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pago]    Script Date: 21/12/2020 18:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pago](
	[idPago] [int] IDENTITY(1,1) NOT NULL,
	[idReserva] [int] NOT NULL,
	[tipoComprobante] [varchar](20) NOT NULL,
	[numComprobante] [varchar](20) NOT NULL,
	[iva] [decimal](4, 2) NOT NULL,
	[totalPago] [decimal](7, 2) NOT NULL,
	[fechaEmision] [date] NULL,
	[fechaPago] [date] NULL,
 CONSTRAINT [pk_Pago] PRIMARY KEY CLUSTERED 
(
	[idPago] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Persona]    Script Date: 21/12/2020 18:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Persona](
	[idPersona] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellidoPaterno] [varchar](50) NOT NULL,
	[apellidoMaterno] [varchar](50) NULL,
	[tipoDocumento] [varchar](50) NOT NULL,
	[numDocumento] [varchar](10) NOT NULL,
	[direccion] [varchar](100) NULL,
	[telefono] [varchar](50) NULL,
	[email] [varchar](100) NULL,
 CONSTRAINT [pk_persona] PRIMARY KEY CLUSTERED 
(
	[idPersona] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Producto]    Script Date: 21/12/2020 18:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Producto](
	[idProducto] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](45) NOT NULL,
	[descripcion] [varchar](255) NULL,
	[unidadMedida] [varchar](20) NOT NULL,
	[precioVenta] [decimal](7, 2) NULL,
 CONSTRAINT [pk_Producto] PRIMARY KEY CLUSTERED 
(
	[idProducto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Reserva]    Script Date: 21/12/2020 18:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reserva](
	[idReserva] [int] IDENTITY(1,1) NOT NULL,
	[idHabitacion] [int] NOT NULL,
	[idCliente] [int] NOT NULL,
	[idTrabajador] [int] NOT NULL,
	[tipoReserva] [varchar](20) NOT NULL,
	[fechaReserva] [date] NOT NULL,
	[fechaIngreso] [date] NOT NULL,
	[fechaSalida] [date] NOT NULL,
	[costoAlojamiento] [decimal](7, 2) NOT NULL,
	[estado] [varchar](15) NULL,
 CONSTRAINT [pk_Reserva] PRIMARY KEY CLUSTERED 
(
	[idReserva] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Trabajador]    Script Date: 21/12/2020 18:10:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Trabajador](
	[idPersona] [int] NOT NULL,
	[sueldo] [decimal](7, 2) NOT NULL,
	[acceso] [varchar](15) NOT NULL,
	[login] [varchar](15) NOT NULL,
	[password] [varchar](20) NOT NULL,
	[estado] [varchar](1) NOT NULL,
 CONSTRAINT [pk_trabajador] PRIMARY KEY CLUSTERED 
(
	[idPersona] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [fk_cliente_Persona] FOREIGN KEY([idPersona])
REFERENCES [dbo].[Persona] ([idPersona])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [fk_cliente_Persona]
GO
ALTER TABLE [dbo].[Consumo]  WITH CHECK ADD  CONSTRAINT [fk_Consumo_Producto] FOREIGN KEY([idProducto])
REFERENCES [dbo].[Producto] ([idProducto])
GO
ALTER TABLE [dbo].[Consumo] CHECK CONSTRAINT [fk_Consumo_Producto]
GO
ALTER TABLE [dbo].[Consumo]  WITH CHECK ADD  CONSTRAINT [fk_Consumo_Reserva] FOREIGN KEY([idReserva])
REFERENCES [dbo].[Reserva] ([idReserva])
GO
ALTER TABLE [dbo].[Consumo] CHECK CONSTRAINT [fk_Consumo_Reserva]
GO
ALTER TABLE [dbo].[Pago]  WITH CHECK ADD  CONSTRAINT [fk_Pago_Reserva] FOREIGN KEY([idReserva])
REFERENCES [dbo].[Reserva] ([idReserva])
GO
ALTER TABLE [dbo].[Pago] CHECK CONSTRAINT [fk_Pago_Reserva]
GO
ALTER TABLE [dbo].[Reserva]  WITH CHECK ADD  CONSTRAINT [fk_Reserva_Cliente] FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([idPersona])
GO
ALTER TABLE [dbo].[Reserva] CHECK CONSTRAINT [fk_Reserva_Cliente]
GO
ALTER TABLE [dbo].[Reserva]  WITH CHECK ADD  CONSTRAINT [fk_Reserva_Habitacion] FOREIGN KEY([idHabitacion])
REFERENCES [dbo].[Habitacion] ([idHabitacion])
GO
ALTER TABLE [dbo].[Reserva] CHECK CONSTRAINT [fk_Reserva_Habitacion]
GO
ALTER TABLE [dbo].[Reserva]  WITH CHECK ADD  CONSTRAINT [fk_Reserva_Trabajador] FOREIGN KEY([idTrabajador])
REFERENCES [dbo].[Trabajador] ([idPersona])
GO
ALTER TABLE [dbo].[Reserva] CHECK CONSTRAINT [fk_Reserva_Trabajador]
GO
ALTER TABLE [dbo].[Trabajador]  WITH CHECK ADD  CONSTRAINT [fk_trabajador_Persona] FOREIGN KEY([idPersona])
REFERENCES [dbo].[Persona] ([idPersona])
GO
ALTER TABLE [dbo].[Trabajador] CHECK CONSTRAINT [fk_trabajador_Persona]
GO
USE [master]
GO
ALTER DATABASE [DBReservaHotel] SET  READ_WRITE 
GO
