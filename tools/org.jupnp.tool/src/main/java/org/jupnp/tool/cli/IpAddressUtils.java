package org.jupnp.tool.cli;

public class IpAddressUtils {

    public static int compareIpAddress(String ip1, String ip2) {
        String[] ip1Parts = ip1.split("[\\.]");
        String[] ip2Parts = ip2.split("[\\.]");
        for (int i = 0; i < ip1Parts.length; i++) {
            int ip1Int = Integer.parseInt(ip1Parts[i]);
            int ip2Int = Integer.parseInt(ip2Parts[i]);
            if (ip1Int < ip2Int) {
                return -1;
            } else if (ip1Int > ip2Int) {
                return 1;
            }
        }
        return 0;
    }

    public static boolean isSameIpAddress(String ip1, String ip2) throws IllegalArgumentException {
        if ((ip1 == null) || (ip2 == null)) {
            return false;
        }
        String[] ip1Parts = ip1.split("[\\.]");
        String[] ip2Parts = ip2.split("[\\.]");
        if (ip1Parts.length != 4) {
            throw new IllegalArgumentException("IpAddress 1 " + ip1 + " is invalid!");
        }
        if (ip2Parts.length != 4) {
            throw new IllegalArgumentException("IpAddress 2 " + ip2 + " is invalid!");
        }
        for (int i = 0; i < ip1Parts.length; i++) {
            try {
                int ip1Int = Integer.parseInt(ip1Parts[i]);
                int ip2Int = Integer.parseInt(ip2Parts[i]);
                if (ip1Int != ip2Int) {
                    return false;
                }
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("IpAddress is invalid (" + ex.getMessage() + "!");
            }
        }
        return true;
    }
}
