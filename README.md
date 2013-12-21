
spirerefresh
============

Unleash the lighting!

Credits
=======

This is a rebuild of the original spire plugin developed by Dups.
It was much loved on my server and then sadly it went away.

I came across the source code for Version 0.1 and went to see if there was an update.
The last post was from Dups on Dec 22, 2012 asking if anyone wanted to take over the project.

No one replied, until now anyway :)

This might be a simple plugin, but a good one. 

All credit for the idea and 95% of the code in the first commit goes to Dups.
I hope to expand the plugin but keep the simple nature that Dups intended.


Thanks
=======

Special thanks goes out to Adamki11s for his awesome Bukkit API guide:
http://wiki.bukkit.org/HUGE_Plugin_Tutorial

Also Thanks to Windwaker for his YAML Config guide:
https://forums.bukkit.org/threads/tut-bukkits-new-fileconfiguration-api-create-a-yaml-configuration.42775/

I have just started learning the Bukkit API and these two guide were very helpful.


Instructions
=============

To build a Spire, place one Diamond block.
Then place three Iron Blocks on top of it.

I
I
I
D

To activate the Spire, simply apply a Red Stone signal to the Diamond block.
This will cause one burst of lighting.

In order to create a continuous lighting storm, you will need to pulse the Red Stone going to the block.


Config.yml
==========

The plugin will automatically create this file the first time is ran.

There are three config options for this plugin:

Safety: This determines a safe zone around the base which can not be hit.

Range: This determines the possible range of the strikes outside the safety zone. Note, due to the laws of probability, higher values will result in a less dense storm.

Strikes: The number of lightning strikes to be induced upon each trigger.


Version History
================

Version 0.1 - 12/20/2013

- Plugin brought up-to-date with version 1.6.4-R2.1 of Bukkit.
