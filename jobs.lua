TEAM_TONE = DarkRP.createJob("test1", {
	color = Color(255, 255,255, 255),
	model = {
		"test.mdl",
	 },
	description = [[test one]],
	weapons = {"keys"},
	command = "tone"
	max = 0,
	salary = 100,
	admin = 0,
	vote = false,
	hasLicense = true,
	candemote = false,
	category = "category",
	ammo = {
		["AR2"] = 2000
	},
	PlayerLoadout = function(ply)
		GAMEMODE:SetPlayerSpeed(ply, GAMEMODE.Config.walkspeed * 1.0, GAMEMODE.Config.runspeed * 1.0)
		ply:SetMaxHealth(500)
		ply:SetHealth(500)
		ply:SetArmor(20)
	end
})

TEAM_TTWO = DarkRP.createJob("test2", {
	color = Color(0, 0,0, 255),
	model = {
		"test2.mdl",
	 },
	description = [[test two]],
	weapons = {"keys", "pocket"},
	command = "ttwo"
	max = 0,
	salary = 100,
	admin = 0,
	vote = false,
	hasLicense = true,
	candemote = false,
	category = "category",
	ammo = {
		["AR2"] = 2000
	},
	PlayerLoadout = function(ply)
		GAMEMODE:SetPlayerSpeed(ply, GAMEMODE.Config.walkspeed * 1.0, GAMEMODE.Config.runspeed * 1.0)
		ply:SetMaxHealth(200)
		ply:SetHealth(200)
		ply:SetArmor(20)
	end
})

